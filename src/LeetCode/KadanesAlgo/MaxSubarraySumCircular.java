package LeetCode.KadanesAlgo;

public class MaxSubarraySumCircular {
    private static int maxSubarraySumCircular(int[] nums) {
        int currentMax=0,currentMin=0,globalMax=nums[0],globalMin=nums[0],total=0;
        // Iterate through the array to calculate the maximum and minimum subarray sums
        // and the total sum of the array
        // This is a variation of Kadane's algorithm that works for circular arrays
        for(int n : nums){
            currentMax = Math.max(currentMax+n, n);
            currentMin = Math.min(currentMin+n, n);
            total+=n;
            globalMax = Math.max(globalMax,currentMax);
            globalMin = Math.min(globalMin,currentMin);
        }
        // If the total sum is equal to the minimum subarray sum, it means all elements are negative
        // In this case, we return the maximum subarray sum found so far
        return globalMax > 0 ? Math.max(globalMax,total - globalMin) : globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums));
    }


}
