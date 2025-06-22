package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

public class LevelOrderTraversal {


    //this solution is almost similar to the BFS Traversal solution
    //only change is we have to keep track of the current Level and add the element to the sublist level by level
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answer  = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();

        if(root == null) return answer;
        TreeNode currentNode= root;
        queue.add(currentNode);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> subList = new ArrayList<>();

            for(int i=0 ; i < level;i++){
                currentNode = queue.remove(0);
                subList.add(currentNode.value);

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            answer.add(subList);
        }
        return answer;
    }

    //another way to write the above code using the java in-built Queue DS
    //Queue.offer() method is similar to the add method
/*    The offer(E e) method of Queue Interface inserts the specified element into this queue if it is possible to do so immediately
    without violating capacity restrictions. This method is preferable to add() method since this method does not throws an exception
    when the capacity of the container is full since it returns false.*/

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().value);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
