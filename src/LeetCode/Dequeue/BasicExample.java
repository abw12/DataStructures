package LeetCode.Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BasicExample {



    public static void main(String[] args) {

        Deque<Integer> dequeue = new ArrayDeque<>();

        Deque<String> sDq = new LinkedList<>();
        dequeue.add(2);
        dequeue.addFirst(10);
        dequeue.addLast(11);

        int first = dequeue.removeFirst();
        int last = dequeue.removeLast();

        dequeue.addLast(19);

        System.out.println(dequeue.poll()); //retrieve and removes the head element of the queue

        //palindrome checker using the deque data structure
        String s = "nittin";
        Deque<Character> q = new ArrayDeque<>();
        for(Character ch : s.toCharArray()){
            q.offer(ch);
        }

        while(q.size() > 1){
            if(!q.pollFirst().equals(q.pollLast())){
                System.out.println("String is not palindrome");
                break;
            }
        }
        if(q.size() <=1)
            System.out.println("String is Palindrome");


    }
}
