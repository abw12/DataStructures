package BST;

class TreeNode{
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class ValidBST {

    //recursion approach using inorder traversal

    /* Inorder traversals can be useful because we know that the inorder traversal of a BST results in traversing the tree in an
    essentially increasing, sorted fashion. So essentially, the helper method is just performing this inorder traversal.
    pre is the node that will store the MINIMUM throughout the traversal. so through each iteration, we keep updating the minimum to contain root.
     But if we see that root is NOT less than the MINIMUM (pre), then we just break and return false*/
    private boolean isValid= true;
    private TreeNode pre= null;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }

    private void helper(TreeNode root){
        //base condition
        if(root == null) return;

        helper(root.left);
        if(pre !=null && pre.val >= root.val){
            isValid=false;
            return;
        }
        pre=root;
        helper(root.right);

    }
}
