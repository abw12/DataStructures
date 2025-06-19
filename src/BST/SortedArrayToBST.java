package BST;

public class SortedArrayToBST {

    private Node sortedArrayToBST(int[] nums)
    {
        return createBST(nums,0,nums.length-1);
    }

    private Node createBST(int[] nums,int l,int r){
        if(l > r){  //base condition for recursion
            return null;
        }
        //we are finding mid or median since we if enter the sorted array directly then it will be an linked list
        //so we find the mid element as head such it will become height balance binary tree
        int mid = l + (r-l)/2;
        Node root = new Node(nums[mid]);
        root.setLeft(createBST(nums,l,mid-1));
        root.setRight(createBST(nums,mid +1,r));
        return root;
    }


    public static void main(String[] args) {

//        int[] nums = {-15,-7,7,15,19,23};
        int[] nums={-10,-3,0,5,9};
        SortedArrayToBST obj = new SortedArrayToBST();
        Node root=obj.sortedArrayToBST(nums); //this is o/p from above [root,left,right] [0,-10,5,null,-3,null,9] is also accepted:

        BST bst =new BST();
        bst.printTree(root);

    }
}
