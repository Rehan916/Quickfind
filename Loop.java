public class Loop{
	private int[] id;
	private int count;

  public Loop(int n){
  	count = n;
  	id = new int[n];
  	for(int i = 0; i < n; i++)
  		id[i] = i;
  }

   public int count(){
   	 return count;
   }

    public int find(int p){
    	validate(p);
    	return id[p];
    }

     private void validate (int p){
     	int n = id.length;
     	if (p<0 || p>=n) {
     		throw new IllegalArgumentException("index" +p+ "is not between 0 and " + (n-1));
     	}
     }

      public boolean connected(int p , int q){
      	 validate(p);
      	 validate(q);
      	 return id[p]==id[q];
      }

       public void union(int p , int q){
       	validate(p);
       	validate(q);
       	int pID = id[p];
       	int qID = id[q];
       	 if(pID == qID) return;
       	 for(int i = 0; i<id.length; i++)
       	 	if(id[i]== pID) id[i] = qID;
       	 count --;
       	}


	public static void main(String[] args){
         int n = StdIn.readInt();
         Loop uf = new Loop(n);
         while(!StdIn.isEmpty()){
         	int p = StdIn.readInt();
         	int q = StdIn.readInt();
         	if(uf.find(p) == uf.find(q)) continue;
         	uf.union(p, q);
         	System.out.println(p + " " +q);
         }
         System.out.println(uf.count() + "components");
	
}
}