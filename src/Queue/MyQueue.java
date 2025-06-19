package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyQueue {
    List<Integer> s1 =new ArrayList<>();
    List<Integer> s2 = new ArrayList<>();
    int front;
    public  MyQueue(){};

    public void push(int x){

        if(s1.isEmpty())
            front=x;

        while(!s1.isEmpty())
            s2.add(s1.remove(s1.size()-1));
        s2.add(x);

        while(!s2.isEmpty())
            s1.add(s2.remove(s2.size()-1));
    }

    public int pop(){
        int popValue=0;

        if(!s1.isEmpty())
            popValue=s1.remove(s1.size()-1);

        front=s1.get(s1.size()-1);
        return popValue;
    }

    public int peek(){
        return front;
    }

    public void printList(){
            System.out.println("Queue.Queue using stack is: "+s1.toString());
    }


    public static void main(String[] args) {

        //implementing queue using the stack's
        MyQueue queue=new MyQueue();
        queue.push(2);
        queue.push(5);
        queue.push(8);
        queue.push(10);
//        queue.pop();
        System.out.println("Peek: " + queue.peek());
        System.out.println("Pop Value: "+ queue.pop());
        System.out.println("Peek: " + queue.peek());
        queue.printList();

        Queue<Integer> q1 = new LinkedList<>();
        q1.poll();
    }


}
