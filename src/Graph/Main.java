package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter no. of vertices");
        int v =  sc.nextInt();
        Graph graph = new Graph(v);
        System.out.println("Enter the edges "); //since its n undirected(bi-directional graph no. of edges will be equal to vertex only
        for(int i=1; i <= v; i++ ){
            System.out.println("Enter source");
            int src = sc.nextInt();
            System.out.println("Enter dest");
            int dest = sc.nextInt();
            graph.addEdgesToList(src,dest);
        }
        graph.printList();
        ArrayList<ArrayList<Integer>> adjList = graph.getAdjList();
        BFSGraph bfsGraph= new BFSGraph();
        System.out.println("is Path Exist: " + bfsGraph.isPathExist(adjList,5,2,5));
    }
}
