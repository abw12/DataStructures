package Graph;

import java.util.ArrayList;

public class Graph {
//    int[][] adjMatrix;


    ArrayList<ArrayList<Integer>> adjList;

    public Graph (int v){
//         adjMatrix= new int[v+1][v+1];
        adjList=new ArrayList<>();
        for(int i=0 ; i <=v ; i++ ){
            adjList.add(new ArrayList<Integer>()); //initialize each index with empty arrayList
        }

    }

//    public void addEdges(int source,int destination){
//        adjMatrix[source][destination]=1;
//        adjMatrix[destination][source]=1;
//    }

    public void addEdgesToList(int source,int dest){
        adjList.get(source).add(dest);
        adjList.get(dest).add(source);
    }

    public void printList(){
        System.out.println("Adjacency List: ");
        for(int i=0 ; i < adjList.size() ; i++){
            System.out.println(i + " : " + adjList.get(i) );
        }
    }

    public ArrayList<ArrayList<Integer>> getAdjList() {
        return adjList;
    }

}
