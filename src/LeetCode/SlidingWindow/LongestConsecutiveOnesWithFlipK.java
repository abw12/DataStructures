package LeetCode.SlidingWindow;

public class LongestConsecutiveOnesWithFlipK {

    private static int longestOnes(int[] nums, int k) {
        int l = 0;
        int longest = 0;
        for(int r =0; r < nums.length; r++){
            // if the current element is 0, we need to decrement k
            if(nums[r] == 0)
                k--;
            // if k is less than 0, we need to move the left pointer
            if(k < 0 ){
                if(nums[l] == 0)
                    k++;
                l++;
            }
            // if we reach here, it means we have a valid window
            // we can check the length of the window
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1,1,0,1};
        int k = 2;

        System.out.println(longestOnes(nums,k));
    }


}
