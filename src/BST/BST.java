package BST;

import java.util.ArrayList;
import java.util.List;

public class BST {

    protected Node root;

    public BST(){
        this.root=null;
    }

    public void insert(int value){
        if(root == null){
            root=new Node(value);
            return;
        }
        Node currentNode=root;
        while(true){
            if(currentNode.getValue() > value) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new Node(value));
                    break;
                }
                currentNode = currentNode.getLeft();
            }else{
                if(currentNode.getRight() == null){
                    currentNode.setRight(new Node(value));
                    break;
                }
                currentNode=currentNode.getRight();
                }
            }
    }

    public void lookup(int value){
        if(root!=null && root.getValue() == value) {
            System.out.println(root.getValue());
        }
         lookupRecursive(root,value);
    }


    public void lookupRecursive(Node node,int value){

        if(node.getLeft()!=null){
            if(node.getLeft().getValue() == value ){
                System.out.println("Found on left node " + node.getLeft().getValue());
            }
            lookupRecursive(node.getLeft(),value);
        }
        if(node.getRight()!=null){
            if(node.getRight().getValue() == value){
                System.out.println("Found on right node "+node.getRight().getValue());
            }
            lookupRecursive(node.getRight(),value);
        }

    }

    public void delete(int value){
        this.root = deleteNode(root,value);
    }

    public Node deleteNode(Node node,int value){
        // base case if node is null or not found
        if (node == null)
            return null;

        // traverse to the node to be deleted
        if (value < node.getValue()){
            node.setLeft(deleteNode(node.getLeft(),value));
        } else if (value > node.getValue()) {
            node.setRight(deleteNode(node.getRight(),value));
        }else{

            // case 1 : if node has no children ( leaf node)
            if (node.getLeft() == null && node.getRight() == null)
                    return null;

            // case 2 : if node has one child
            if (node.getLeft() == null){
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            //case 3 : if node has two children ( find the inorder successor or predecessor)
            // here we are finding inorder successor ( smallest node in right subtree)
            Node successor = findMin(node.getRight()); // # find inorder successor
            node.setValue(successor.getValue()); // copy successor value
            node.setRight(deleteNode(node.getRight(),successor.getValue())); //delete successor from its original position
        }
        return node;
    }

    public Node findMin(Node node){
        while(node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    public void BFS(){
        List<Integer> nodes = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        Node currentNode=root;
        queue.add(currentNode);
        while(!queue.isEmpty()){
            currentNode=queue.remove(0);
            System.out.println("Traverse: " + currentNode.getValue());
            nodes.add(currentNode.getValue());
            if(currentNode.getLeft()!=null){
                queue.add(currentNode.getLeft());
            }
            if(currentNode.getRight()!=null){
                queue.add(currentNode.getRight());
            }
        }
        System.out.println("BFS: "+nodes);

    }



        //DFS Inorder
    public List<Integer> DFSInorder(){
        List<Integer> visitedNode = new ArrayList<>();

        return traverseInorder(visitedNode,root);
    }

    public List<Integer> traverseInorder(List<Integer> list ,Node node){
        System.out.println("Path: " + node.getValue());
        if(node.getLeft()!=null){
            traverseInorder(list,node.getLeft());
        }
        list.add(node.getValue());
        if(node.getRight()!=null){
            traverseInorder(list,node.getRight());
        }
        return list;
    }


    //DFS PreOrder
    public List<Integer> DFSPreOrder(){
        List<Integer> list = new ArrayList<>();

        return traversePreOrder(root,list);
    }

    public List<Integer> traversePreOrder(Node node,List<Integer> list){
        System.out.println("Path: " + node.getValue());
        list.add(node.getValue());
        if(node.getLeft()!=null){
            traversePreOrder(node.getLeft(),list);
        }
        if(node.getRight()!=null){
            traversePreOrder(node.getRight(),list);
        }
        return list;
    }
    //DFS PostOrder
    public List<Integer> DFSPostOrder(){
        List<Integer> list = new ArrayList<>();

        return traversePostOrder(root,list);
    }

    public List<Integer> traversePostOrder(Node node,List<Integer> list){
        System.out.println("Path: " + node.getValue());
        if(node.getLeft()!=null){
            traversePreOrder(node.getLeft(),list);
        }
        if(node.getRight()!=null){
            traversePreOrder(node.getRight(),list);
        }
        list.add(node.getValue());
        return list;
    }





    //by recursive call
    public void printTree() {
        printTree(root);
    }
    //by recursive call
    public void printTree(Node node) {
        System.out.print(node.getValue());
        System.out.println();
        if(node.getLeft() != null) {
            System.out.print( "Left: ");
            printTree(node.getLeft()); //recursive call
        }
        if(node.getRight() != null) {
            System.out.print("Right: ");
            printTree(node.getRight()); //recursive call
        }
    }

    public static void main(String[] args) {

        BST rootNode = new BST();
        rootNode.insert(5);
        rootNode.insert(4);
        rootNode.insert(2);
        rootNode.insert(7);
        rootNode.insert(6);
        rootNode.insert(8);
//        rootNode.insert(6);
//        rootNode.printTree();
//        rootNode.lookup(11);
//        rootNode.BFS();
//        System.out.println("InOrder: " +rootNode.DFSInorder());
//        System.out.println("PreOrder: " + rootNode.DFSPreOrder());
//        System.out.println("PostOrder: "+ rootNode.DFSPostOrder());

        System.out.println("Initial BST: ");
        rootNode.printTree();

//        System.out.println("Case 1: Delete the leaf node");
//        rootNode.delete(2);
//        rootNode.printTree();

//        System.out.println("Case 2: Deleting the node with one child");
//        rootNode.delete(4);
//        rootNode.printTree();

        System.out.println("Case 3: Deleting the node with two children");
        rootNode.delete(7);
        rootNode.printTree();

    }
}
