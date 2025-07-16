package LeetCode.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class BasicPQExample {

    public static void main(String[] args) {

        //every insertion or deletion operation on priority queue internally performs an heapify operation on the heap (max or min heap)
        //these reorder of the elements according to the heap(max or min) used in priority queue

        //by default the Priority Queue in java uses the min. heap (therefore min value will remian at peek() front of queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        minHeap.add(2);
        minHeap.add(10);
        minHeap.add(22);
        minHeap.add(90);
        minHeap.add(1);
        minHeap.add(7);

        System.out.println("Initial minHeap: " + minHeap);
        //peek() method retrieve the head of queue(front of queue) but does not remove it
        System.out.println("Peek of minHeap: " + minHeap.peek());
        //fetch the head of queue and remove it from the queue
        System.out.println("Poll of minHeap: "+ minHeap.poll());
        System.out.println("Remaining elements in minHeap: " + minHeap);

        //to use the maxHeap in java we have to pass the comparator in the constructor
        // (the Collections.reverseOrder() =Returns a comparator that imposes the reverse of the natural ordering on a collection of objects
        // that implement the Comparable interface)

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(2);
        maxHeap.add(10);
        maxHeap.add(22);
        maxHeap.add(90);
        maxHeap.add(1);
        maxHeap.add(7);

        System.out.println("Initial maxHeap: " + maxHeap);
        //peek() method retrieve the head of queue(front of queue) but does not remove it
        System.out.println("Peek of maxHeap: " + maxHeap.peek());
        //fetch the head of queue and remove it from the queue
        System.out.println("Poll of maxHeap: "+ maxHeap.poll());
        System.out.println("Remaining elements in maxHeap: " + maxHeap);

    }


}
