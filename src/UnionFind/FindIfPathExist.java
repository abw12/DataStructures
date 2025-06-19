package UnionFind;

public class FindIfPathExist {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int nodes=6;
        //method to check if path exist between source to destination
        boolean isConnected=isValidPath(nodes,edges,0,1);
        System.out.println("Path exist: "+isConnected);
    }

    private static boolean isValidPath(int n,int[][]edges,int source ,int dest ){
        DisjointSetUnion graph = new DisjointSetUnion(n);
        for(int[] edge: edges){
            graph.union(edge[0],edge[1]);
        }
            return graph.isConnected(source,dest);
    }
}
