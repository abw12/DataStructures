package BinaryTree;

public class MaxDepthOfBT {

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right ==null){ //this condition is for leaf nodes to directly return 1 as there is no further node downstream
            return 1;
        }
//        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1; same thing return below in elaborated way


        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);

        int bigger=Math.max(leftDepth,rightDepth);
        return bigger +1;
    }

    public static void main(String[] args) {

    }

}
