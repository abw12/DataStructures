package BinaryTree;

public class TreeNode {

        public BinaryTree.TreeNode left;
        public BinaryTree.TreeNode right;
        public int value;
        public TreeNode(){}
        public TreeNode(int value){
            this.value=value;
        }
        public TreeNode(int value, BinaryTree.TreeNode left, BinaryTree.TreeNode right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
}
