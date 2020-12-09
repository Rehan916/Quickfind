public class WeightedQuickUnion{
	 private int[] parent;
	 private int[] size;
	 private int count;

  public WeightedQuickUnion(int n){
     count = n;
     parent = new int[n];
     size = new int[n];
     for(int i = 0; i<n; i++){
     	parent[i] = i;
     	size[i] = 1;
     }
  }
    public int count(){
    	return count; 
    }

    public int find(int p){
    	validate(p);
    	while(p != parent[p])
    		p = parent[p];
    	 return p;
    }

    public boolean connected(int p, int q){
    	return find(p) == find(q);
    }

    private void validate(int p){
    	int n = parent.length;
    	if(p < 0 || p >= n){
    		  throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
    	}
    }

     public void union(int p, int q){
     	int rootP = find(p);
     	int rootQ = find(q);
     	if(rootP==rootQ) return;

     	if(size[rootP] < size[rootQ]){
     		parent[rootP] = rootQ;
     		size[rootQ] += size[rootP];
     	}
     	else {
     		parent[rootQ] = rootP;
     		size[rootP] += size[rootQ];
     	}
     	count--;
     }	 
	public static void main(String[] args){
         int n = StdIn.readInt();
         WeightedQuickUnion uf = new WeightedQuickUnion(n);
         while(!StdIn.isEmpty()){
         	int p = StdIn.readInt();
         	int q = StdIn.readInt();
         	if(uf.find(p) == uf.find(q)) continue;
         	 uf.union(p, q);
         	 System.out.println(p + " " + q); 
         }
         System.out.println(uf.count() + "components");
	}
}