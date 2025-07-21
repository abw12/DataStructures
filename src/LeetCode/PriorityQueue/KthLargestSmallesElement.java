package LeetCode.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestSmallesElement {

    public static void main(String[] args) {
        int[] arr = {2,19,10,35,44,39,7};
        int k=4;
        //find kth largest element
        findLargestElement(arr,k);
        System.out.println("Naive Approach :: " + navieApproach(arr,k));
    }

    private static Integer navieApproach(int[] nums,int k){
       /* 1. First add all the element from array into PQ.
        2. Then remove the first smallest element till len-k.
        3. Then return the head of the PQ I.e peek() which will be the kth largest element*/
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for(int num : nums){
            min_heap.offer(num);
        }
        int len = min_heap.size();
        for(int i=0; i < len-k ;i++){
            min_heap.poll();
        }
        return min_heap.poll();
    }

    //here we are only adding the first k element in the PQ.
    // Then comparing each element from k to len of nums array whether its max than the current head of PQ.
    // If yes remove the current head and add the current element.
    private static void findLargestElement(int[] arr, int k) {

        //by default the priority queue create a minHeap in java
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0 ; i < k ; i++ ){
            minHeap.offer(arr[i]); //add only first k elements from input array into PQ
        }

        //loop over from arr[k] to arr[n-1] and check on each element if it's greater than the peek of the queue
        //if yes then remove the peek of the queue and add that element in the queue else just continue
        for(int i=k ; i < arr.length ; i++){
            if(!minHeap.isEmpty() && minHeap.peek() < arr[i]){
                minHeap.poll();
                minHeap.offer(arr[i]); //we can also use add() method, add method internally call same offer method.
            }
        }

        System.out.println("kth largest elemnt in given array is: "+ minHeap.peek());


    }
}
