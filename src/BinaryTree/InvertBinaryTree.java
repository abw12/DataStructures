package BinaryTree;

public class InvertBinaryTree {

//    Given the root of a binary tree, invert the tree, and return its root.


//    solved this solution using the Post Order DFS , we swap at each level root of the subtree
    public TreeNode invertBinary(TreeNode root){
        //Base condition
        if(root == null) return root;

        invertBinary(root.left);
        invertBinary(root.right);


        //swap the subtree when we are at the root node of each subtree
        if(root.left!=null && root.right!=null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
