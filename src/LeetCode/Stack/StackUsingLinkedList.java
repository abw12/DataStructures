package LeetCode.Stack;


import java.util.Iterator;

//stack using linkedlist always take constant time in the worst case scenario
public class StackUsingLinkedList implements Iterable<String> {

    private Node firstNode = null;

//   Note that our stack iterator returns the items in LIFO order, whereas \verb#java.util.LeetCode.Stack#java.util.LeetCode.Stack returns them in FIFO order.
    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String>{

        private Node current = firstNode;

        @Override
        public boolean hasNext(){ return current!=null; }

        @Override
        public String next() {
            String item = current.item;
            current = current.next;
            return item;
        }

        //this method is not supported
        @Override
        public void remove() {
            Iterator.super.remove();
        }

    }

    private class Node {
        String item;
        Node next;
    }

    public void push(String item){
        Node previouslyFirstMode = firstNode;
        firstNode = new Node();
        firstNode.item=item;
        firstNode.next = previouslyFirstMode;
    }

    public String pop(){
       String item = firstNode.item;
       firstNode = firstNode.next; //previously firstNode will return its value we'll change the position of variable from firstNode to its next
       return item;
    }

    public boolean isEmpty(){
        return  firstNode == null;
    }

    public int size(){
        int size = 0;
        Node CurrentNode = firstNode;
        while(CurrentNode != null){
            size++;
            CurrentNode=CurrentNode.next;
        }
        return size;
    }

}

class Main{
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push("abhishek");
        stack.push("wasave");
        stack.push("suresh");
        stack.pop();

        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()){
            String value = iterator.next();
            System.out.println(value);
        }
        
        System.out.println("stack size: " + stack.size() );

    }
}
