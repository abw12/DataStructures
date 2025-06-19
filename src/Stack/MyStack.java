package Stack;

import java.util.LinkedList;
import java.util.Queue;


class StackUsingOneQueue{

    Queue<Integer> q1 = new LinkedList<>();
    int top;

    public StackUsingOneQueue(){};

    public void push (int x){
        q1.add(x);
        top=x;
        int size = q1.size();
        while(size > 1){
            q1.add(q1.remove());   //bcoz LinkedList is the implementation of the queue it remove the first (head) element from the list
                                    //so here we remove first element and add it at the end of the list (inverting the list)
                                    //since to implement stack using queue we need last inserted element at the front of the queue
            size--;
        }
    }

    public int pop(){
        int popValue = q1.remove(); //remove from the front of queue
        if(!q1.isEmpty())
            top=q1.peek();
        else
            top=0;
        return popValue;
    }

    public int peek(){
        return top;
    }

    public boolean empty(){
        return q1.size() == 0 ? true : false;
    }
    public void printList(){
        System.out.println("Better approach stack: " + q1.toString());
    }
}

public class MyStack {

    private static Queue<Integer> q1 = new LinkedList<>(); // we use LinkedList obj  with queue interface
    // since queue remove() method pop element from front & arrayList remove() we have to give the index
    private static Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public void push(int x){
        q1.add(x);
        top=x;
    }

    public int pop(){
        int popValue;
        while(q1.size() > 1){
            top=q1.remove();
            q2.add(top);
        }
        popValue=q1.remove();

        Queue<Integer> temp = q1;  // here we swap q1 to q2 instead of copying all element from q2 to q1 , we make q2 empty
        q1=q2;
        q2=temp;

        return popValue;
    }

    public int top(){
        return top;
    }

    public boolean empty(){
        return q1.size() == 0;
    }


    public static void main(String[] args) {
        //implementing stack using the queue's
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("POP: "+stack.pop());
        System.out.println("TOP: "+stack.top());
        System.out.println("is Empty ? : "+stack.empty());
        System.out.println(q1.toString());

        //follow-up question to implement stack using only one queue
        StackUsingOneQueue stack2= new StackUsingOneQueue();
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        System.out.println("POP 2: "+stack2.pop());
        System.out.println("TOP 2:  "+stack2.peek());
        System.out.println("is Empty ? : "+stack2.empty());
        stack2.printList();
    }
}
