package LeetCode.KadanesAlgo;

/*Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



        Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.*/
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
//        This is because removing the smallest subarray sum from the total sum effectively gives the largest wrap-around subarray sum.

    }

    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums));
    }


}
