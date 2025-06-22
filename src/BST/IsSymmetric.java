package BST;

public class IsSymmetric {


    private static boolean isSymmetry(Node left, Node right){
        //base condition is when we reach a leaf node
        if(left !=null && right != null) {
            return true;
        }

        if(left != null && right != null && left.getValue() == right.getValue()){
            return isSymmetry(left.getLeft(),right.getRight()) && isSymmetry(left.getRight(),right.getLeft()); //if this recursion check is success for all node than we can say that the tree is symmetric
        }
        return false;
    }

    public static void main(String[] args) {
        BST rootNode =new BST();
        System.out.println(isSymmetry(rootNode.root.getLeft(),rootNode.root.getRight()));
    }
}
