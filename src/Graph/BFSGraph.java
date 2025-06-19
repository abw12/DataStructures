package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSGraph {

    public  boolean isPathExist(ArrayList<ArrayList<Integer>> adjlist , int src,int dest,int v){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v+1]; // since array start from 0 and if source start from 1 then add v+1
        for(int i=0; i < v ; i++){
            visited[i]=false;
        }
        queue.add(src);
        while(!queue.isEmpty()){
            int cur = queue.remove();
            for(int i=0; i < adjlist.get(cur).size() ; i++){
                int neighbourNode = adjlist.get(cur).get(i);
                if(visited[neighbourNode] == false){
                    visited[neighbourNode]=true;
                    queue.add(neighbourNode);

                    if(neighbourNode == dest){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
