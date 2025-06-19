package PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestSmallesElement {

    public static void main(String[] args) {
        Integer[] arr = {2,19,10,35,44,39,7};
        int k=4;
        //find kth largest element
        findLargestElement(arr,k);

    }

    private static void findLargestElement(Integer[] arr, int k) {

        //by default the priority queue create a minHeap in java(contain kth largest element)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0 ; i < k ; i++ ){
            minHeap.add(arr[i]); //add first k element into queue
        }

        //loop over from arr[k] to arr[n-1] and check on each element if it's greater than the peek of the queue
        //if yes then remove the peek of the queue and add that element in the queue else just continue
        for(int i=k ; i < arr.length ; i++){
            if(!minHeap.isEmpty() && minHeap.peek() < arr[i]){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        System.out.println("kth largest elemnt in given array is: "+ minHeap.peek());


    }
}
