package LeetCode.SlidingWindow;

public class MaxSubArrayAvg1 {

    private static double maxSubArrAvg(int[] nums,int k){
        int len = nums.length;
        //check the edge case (but it's given in question constraint that 1 <= k <= n <= 10^5)
        // therefore below check is not necessary for this question
        if(len < k){
            System.out.println("Invalid: Window size is larger than array");
            return -1;
        }

        // first find avg of the initial window size of k
        double currSum = 0;
        for(int r=0; r < k ;r++){
            currSum+=nums[r];
        }
        double maxSum=currSum;
        for(int r=k; r < len; r++){
            currSum+=nums[r] - nums[r-k];
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum/k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("Max SubArray Avg :: " + maxSubArrAvg(nums,k));
    }
}
