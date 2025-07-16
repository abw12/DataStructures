package LeetCode.PriorityQueue;

import java.util.*;

public class KthSmallestPairs {

    private static List<List<Integer>> kSmallestPairs(int[] nums1,int[] nums2,int k){
        PriorityQueue<int[]>  pq = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
        Set<int[]> visitedIndicesPair = new HashSet<>();
        //store the final list of k pairs
        List<List<Integer>> result = new ArrayList<>();

        pq.offer(new int[]{nums1[0]+nums2[0],0,0}); //add to the pq
        visitedIndicesPair.add(new int[]{0,0}); //keep track of the visited indices pair

        while(!pq.isEmpty() && result.size() < k){
            int[] pairs = pq.poll(); //return and remove the peak node
            int i = pairs[1];
            int j = pairs[2];
            result.add(List.of(i,j));

            // explore next pairs by moving the right in nums1
            if(i+1 < nums1.length && !visitedIndicesPair.contains(new int[]{i+1,j})){
                pq.offer(new int[]{nums1[i+1]+nums2[j],i+1,j});
                visitedIndicesPair.add(new int[]{i+1,j});
            }

            // explore next pairs by moving the right in nums2
            if(j+1 < nums2.length && !visitedIndicesPair.contains(new int[]{i,j+1})){
                pq.offer(new int[]{nums1[i] + nums2[j+1],i,j+1});
                visitedIndicesPair.add(new int[]{i,j+1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};
        int k = 3;
        System.out.println( k + " Smallest sum of Pairs :: " + kSmallestPairs(nums1,nums2,k));
    }
}
