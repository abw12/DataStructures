package LeetCode.Stack;


/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        Implement the MinStack class:

        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.
        You must implement a solution with O(1) time complexity for each function.*/
public class MinStackLeetCode {

    private Node head;

    public void push(int val){
        if(head == null){
            head = new Node(val,val,null); //for the first node (first value inserted in stack)
        }else{
            head = new Node(val,Math.min(val,head.min),head); //maintaining the min value at each Node level
        }
    }

    public void pop(){
        head=head.next;
    }

    public int top(){
        return head.val;
    }

    public int getMin(){
        return head.min;
    }

    private class Node{

        int val;
        int min;
        Node next;

        public Node(int val,int min,Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }
}
