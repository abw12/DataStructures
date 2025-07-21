package LeetCode.PriorityQueue;

import java.util.*;


/*class Pair<K,V>{
    public final K key;
    public final V value;
    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }
}*/
//create the equals and hashcode method if using the above class otherwise the it will not able to identify the duplicate and

// We can create a record in the Java 17 for the same purpose ( creating a custom Pair class like above)
record Pair<K, V>(K key, V value) {}

public class KthSmallestPairs {

    private static List<List<Integer>> kSmallestPairs(int[] nums1,int[] nums2,int k){
        //this will hold 3 element in the integer array [sum of pairs, i, j]
        // custom comparator is saying that minHeap will heapify( re-shuffle the PQ) based on the sum (i.e a[0], as a[0]=sum, a[1]=ith index, a[2]=jth index
        PriorityQueue<int[]>  pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));  // equivalent to writing comparator as (a,b) -> (a[0] - b[0])
        Set<Pair<Integer,Integer>> visitedIndicesPair = new HashSet<>(); // this will store all unique indices of the Pairs which need to visit
        //store the final list of k pairs
        List<List<Integer>> result = new ArrayList<>();

        pq.offer(new int[]{nums1[0]+nums2[0],0,0}); //add to the pq
        visitedIndicesPair.add(new Pair<>(0,0)); //keep track of the visited indices pair

        while(!pq.isEmpty() && result.size() < k){
            int[] top = pq.poll(); //return and remove the peak node
            int i = top[1];
            int j = top[2];
            result.add(List.of(nums1[i],nums2[j])); //add the value of indices pair

            // explore next pairs by moving the right in nums1
            if(i+1 < nums1.length && !visitedIndicesPair.contains(new Pair<>(i+1,j))){
                pq.offer(new int[]{nums1[i+1]+nums2[j],i+1,j});
                visitedIndicesPair.add(new Pair<>(i+1,j));
            }

            // explore next pairs by moving the right in nums2
            if(j+1 < nums2.length && !visitedIndicesPair.contains(new Pair<>(i,j+1))){
                pq.offer(new int[]{nums1[i] + nums2[j+1],i,j+1});
                visitedIndicesPair.add(new Pair<>(i,j+1));
            }
        }
        return result;
    }


    // Time = O(k log m) where m is the size of nums1 and k is limig given is the question.
     // space = O(m)
    // Treat the matrix of sums as a k-way merge problem. Always pop the current smallest sum and lazily push its “next” neighbours.
    public List<List<Integer>> optimalSolution(int[] nums1, int[] nums2, int k){
            int m=nums1.length;
            int n=nums2.length;
            List<List<Integer>> result = new ArrayList<>();
            //below comparingInt function is doing same as => (a,b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
           // (nums1[i] + nums2[j]) -(nums1[i] + nums2[j]) where a and b are two objects(int[] in PQ) compared.
           // example comparing indices (0,1) and (1,0) => 3 & 9 => 3-9 => -6, so it will be kept on top of the PQ. as we maintain minHeap
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
            // Create the first column of the matrix.
            //Each tuple stores indices (i, j) into the two arrays. The heap key is nums1[i] + nums2[j].
            for(int i = 0; i < Math.min(k,m); i++){ // only need k rows at most
                pq.offer(new int[]{i,0}); // (row i, col j) adding firs col (0,0),(1,0),(2,0)
            }

            while(k-- > 0 && !pq.isEmpty()){
                int[] top = pq.poll(); //remove and return the top of the PQ. (returns smallest unreported pair)
                int i = top[0]; // i represent nums1
                int j = top[1]; //j represent nums2
                result.add(List.of(nums1[i],nums2[j]));

                if(j+1 < n ){   // push neighbour to the right
                    pq.offer(new int[]{i,j+1});
                }
            }
            return result;
    }
    // nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    /*Initial heap: (1,2)=3 , (7,2)=9 , (11,2)=13   -> [3,9,13]
    pop 3 : push right neighbour (1,4)=5         -> [5,9,13]
    pop 5 : push (1,6)=7                         -> [7,9,13]
    pop 7 : push (7,4)=11                        -> [9,11,13]
    output so far : [ (1,2), (1,4), (1,6) ]      // done (k=3)*/


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,5,6};
        int[] nums2 = new int[]{3,5,7,9};
        int k = 20;
        System.out.println( k + " Smallest sum of Pairs :: " + kSmallestPairs(nums1,nums2,k));
    }
}
