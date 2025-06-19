package BST;
/*Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
adding up all the values along the path equals targetSum.
        A leaf is a node with no children.*/



//here we are following the top-down approach of DFS
//checking the currentSum with the targetSum only at the leaf node
public class PathSum {

    public  boolean hasPathSum(TreeNode root, int targetSum) {
        //base condition
        if(root == null) return false;
        int currentSum=0;
        return traversePath(root,targetSum,currentSum);

    }

    private boolean traversePath(TreeNode root , int targetSum,int currentSum){
        //base condition
        if(root == null) return false;
        //for leaf node
        if(root.left == null && root.right ==null){
            currentSum+=root.val;
            //check on the leaf node if the currentSum matches the targetSUm
            //since here we follow top-down approach
            if(currentSum == targetSum){
                return true;
            }
        }
        return traversePath(root.left,targetSum,currentSum + root.val)
                || traversePath(root.right,targetSum,currentSum + root.val);
    }
}
