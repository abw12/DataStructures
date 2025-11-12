package LeetCode.PriorityQueue;

import java.util.*;

//Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.

public class TopKFrequentElement {

    //This solution is based on Bucket Sort technique.
    // This is Optimal solution with O(n) Time and O(n) Space
    // int[] num ={1,2,2,4,5,6,6,7,8,8,8};
    //        int k = 3;
    private static List<Integer> findTopKthElement(int[] num, int k) {
        int len = num.length;
//        int[] output = new int[k];
//        Map<Integer, Integer> freq = new Map.HashMap<>();
//        for (int i = 0; i < len; i++) {
//            freq.put(num[i], freq.getOrDefault(num[i], 0) + 1);
//        }
//        Map<Integer, Integer> sortedByValue = freq.entrySet().stream()
//                .sorted(Comparator.comparingInt(Map.Entry::getValue))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k1, LinkedHashMap::new));

            //List<Integer>[] declares an array of List objects
     /*   Each element in this array will be a List that stores Integer values.
          While you cannot directly create an array of a generic type, Java allows you to create an array of raw Lists and cast it to the parameterized type if needed.
          This is a common pattern for situations like bucket sort, where you often need an array of lists*/
        List<Integer>[] bucket = new List[num.length+1]; //+1 because while filling the frequency the numbers starts from 1 and list is o index based
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            freq.put(num[i], freq.getOrDefault(num[i], 0) + 1);
        }

        for(int key : freq.keySet()){
            int frequency = freq.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>(); //build an array of list (array index consist of list )
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int pos = bucket.length - 1; pos >= 0 && res.size() < k ; pos-- ){
            if(bucket[pos] != null){
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    // 2nd solution using the PriorityQueue* maxHeap) approach
    // adding all element into the PQ which makes this solution slowest compared to others
    record Node(int element,int freq){}
    private static int[] useMaxHeapPQ(int[] nums, int k){
        int[] result = new int[k];
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.freq,a.freq)); //this custom comparator will create max heap on basis of the freq
        // first count the frequency per element and store it in the map
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1); //counting the freq of each element
        }
        // Add all elements from the map in the PQ
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            maxHeap.offer(new Node(entry.getKey(), entry.getValue()));
        }
        // Now retrieve the first kth element from the PQ which are the kth most frequent in the array
        for(int i=0 ; i < k;i++){
            result[i]= Objects.requireNonNull(maxHeap.poll()).element();
        }
        return result;
    }

    // Heap will only store k-size element in the minHeap
    // both the PQ based approach uses the same Time but this approach is better on space complexity since we only keep k-size element in the heap
    private static int[] useMinKSizeHeap(int[] nums,int k){
        int[] result = new int[k];
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq)); //create a minHeap
        // first count the frequency per element and store it in the map
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1); //counting the freq of each element
        }
        for(var e: map.entrySet()){
            minHeap.offer(new Node(e.getKey(),e.getValue()));
            if(minHeap.size() > k) minHeap.poll(); //only keep k-size nodes in the heap ( at the end it will hold top k frequent elements only in the heap)
        }
        // Now retrieve the first kth element from the PQ which are the kth most frequent in the array
        for(int i=0 ; i < k;i++){
            result[i]= Objects.requireNonNull(minHeap.poll()).element();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num ={1,2,2,4,5,6,6,7,8,8,8};
        int k = 3;
        System.out.println("Using bucket sort :: " + findTopKthElement(num, k));
        System.out.println("Using PQ -  maxHeap :: " + Arrays.toString(useMaxHeapPQ(num, k)));
        System.out.println("Using PQ -  useMinKSizeHeap :: " + Arrays.toString(useMinKSizeHeap(num, k)));
    }
}
