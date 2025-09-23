package LeetCode.SlidingWindow;

/*Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
sum is greater than or equal to target. If there is no such subarray, return 0 instead.*/

// Time complexity is O(n) and space complexity is O(1)
public class MinSubArrayLen {

    private static Integer minSubArrayLen(int[] nums,int target){
        int len = nums.length;
        int l= 0;
        int minLen = Integer.MAX_VALUE;
        int currSum=0;
        for(int r=0; r < len; r++){
            currSum+=nums[r];
            while(currSum >=target){
                if(r-l+1 < minLen)
                    minLen = r-l+1;
                currSum-=nums[l];
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums= {2,3,1,2,4,3};
        int target = 7;
        System.out.println("MinSubArrayLength :: "+ minSubArrayLen(nums,target));
    }
}
