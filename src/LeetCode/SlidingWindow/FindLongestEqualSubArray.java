package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This Question is solved similar to the question of finding the longest subarray with K replacements
// Only difference is that here we return the maxFreq in a valid window of the subarray instead of the length of the window size

//sliding window + frequency counter
//Window [l … r] is always the longest prefix ending at r such that
//deletionsNeeded = windowLength – maxFreq ≤ k.
//        Reason: If the window ever violates the k limit we advance l until it is valid again.
//
//maxFreq tracks the most common value inside the window.
//
//Because the window is maximal at each r, every value of maxFreq observed is a candidate answer.
//The loop keeps the largest such value, so the final maxFreq equals the length of the best achievable equal sub-array.
public class FindLongestEqualSubArray {
    private static Integer longestEqualSubArrayUsingMap(List<Integer> nums,int k) {
        //Sliding window approach with Freq map
         Map<Integer,Integer> map = new HashMap<>();
         int max_freq = 0; //highest frequency in current window
         int l=0;
         for(int r =0; r < nums.size(); r++){
             int el = nums.get(r);
             //extend window to the right
             map.put(el,map.getOrDefault(el,0)+1);
             max_freq = Math.max(max_freq,map.get(el));
//             shrink from the left while > k deletions would be needed
             if((r-l+1) - max_freq > k ){
                 int left_el = nums.get(l);
                 //shrink the window from the left
                 map.put(left_el,map.get(left_el)-1);
                 l++;
             }
         }
         return max_freq;
    }

    public static Integer longestEqualSubArrayUsingBucketSort(List<Integer> nums, int k) {
        //Sliding window approach with Bucket sort
        int[] count = new int[nums.size()+1]; // since the constraint is given that 1 <= nums[i] <= nums.length therefore we cna use such array
        int maxFreq=0;
        for(int r=0, l=0; r < nums.size(); r++){
            int el = nums.get(r);
            maxFreq=Math.max(maxFreq,++count[el]);
            if((r-l+1) - maxFreq > k){
                int leftEl = nums.get(l);
                count[leftEl]--;
                l++;
            }
        }
        return maxFreq;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,1,2,2,1,1);
        System.out.println(longestEqualSubArrayUsingMap(nums,2));
        System.out.println(longestEqualSubArrayUsingMap(nums,2));
    }


}
