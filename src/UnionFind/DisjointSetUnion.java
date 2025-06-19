package UnionFind;

public class DisjointSetUnion {

    private int[] graph;
    private int N;

    public DisjointSetUnion(int N){
        this.N=N;
        this.graph=new int[this.N];
        for(int i=0; i < this.N ; i++){
            graph[i]=i;
        }
    }

    public int root(int u){
        int x=u;
        while(x!= graph[x]){
            x= graph[x];
        }
        this.graph[u]=x;
        return x;
    }

    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    public void union (int p,int q){
        if(p!=q){
            int i = root(p);
            int j = root(q);
            graph[i]=j;
        }
    }
}
