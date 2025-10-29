package LeetCode.Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicExample {



    public static void main(String[] args) {

        Deque<Integer> dequeue = new ArrayDeque<>();
        dequeue.add(2);
        dequeue.addFirst(10);
        dequeue.addLast(11);

        int first = dequeue.removeFirst();
        int last = dequeue.removeLast();

        dequeue.addLast(19);

        System.out.println(dequeue.poll()); //retrieve and removes the head element of the queue

    }
}
