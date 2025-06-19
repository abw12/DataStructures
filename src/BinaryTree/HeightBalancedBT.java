package BinaryTree;

//this was my solution
//it takes O(n) time
public class HeightBalancedBT {

    private boolean isBalanced=true;

    public boolean isHeightBalanced(TreeNode root){
        if(root == null) return true; //base condition for empty BT as empty BT are height balanced BT

        int rightSubTreeHeight = calculateHeight(root.right);
        int leftSubTreeHeight = calculateHeight(root.left);

        if( Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1){
            isBalanced=false;
            return isBalanced;
        }
        if(root.left!=null){
            isHeightBalanced(root.left);
        }
        if(root.right!=null){
            isHeightBalanced(root.right);
        }
        return isBalanced;
    }
    private int calculateHeight(TreeNode node) {
        if(node ==null) return 0;

        return Math.max( calculateHeight(node.left) ,calculateHeight(node.right)) +1;

    }
}
//    it takes O(n) time
class HeightBalanceBT2{
    private boolean result= true;

    public boolean heightBalanced(TreeNode root){
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        int r = maxDepth(node.right);
        int l = maxDepth(node.left);

        if(Math.abs(l-r) > 1){
            result = false;
        }
        return  Math.max(l,r) +1;

    }
}