package LeetCode.SlidingWindow;

// LeetCode Problem: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
// This class is a placeholder for the solution to the problem of finding the longest subarray of 1s after deleting one element.
// The solution will involve using a sliding window technique to efficiently find the maximum length of such a subarray.
public class LongestSubarrayOfOnesDeleting {

    private static int longestSubArray(int[] nums){
        int longest = 0;
        int allowed = 1;
        int len = nums.length;
        if (nums.length == 0) return 0;
        int l = 0;
        for(int r =0; r < len; r++){
            // if the current element is 0, we need to decrement allowed
            if(nums[r] == 0)
                allowed--;
            if(allowed < 0 ){
                if(nums[l] == 0)
                    allowed++;
                l++;
            }
            longest = Math.max(longest,r-l);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1};
        System.out.println(longestSubArray(nums));
        // Output: 5, as we can delete one 0 to get the longest sub

    }
}
