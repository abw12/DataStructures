package LeetCode.KadanesAlgo;
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// A subarray is a contiguous part of an array.


public class MaxSubArray {
    //this method have o(n^2) time complexity but not optimal for very very big array
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return  nums[0];
        }

        int highest=Integer.MIN_VALUE;
        int total = 0;
//        int loop = 0;
//        int i = 0;
//        for (; i < nums.length; i++) {
//            total = total + nums[i];
//            highest=Math.max(highest,total);
//            if (i == nums.length - 1 && loop < nums.length) {
//                loop++;
//                i=loop-1;
//                total=0;
//            }
//        }
        //above looping is similar to this one as both are quadratic in nature and loop over array twice so time complexity is o(n^2);
        for (int i=0 ; i < nums.length ; i++){
            total=0;
            for(int j=0;j < nums.length ; j ++){
                total+=nums[j];
                highest=Math.max(highest,total);
            }
        }

        return highest;
    }


    //this is better solution with o(n) linear time complexity here we are looping only once over the array
    //make the maxSum=0; if sum is negative(sum < 0).since we don't carry the negative number to add with the  next number in the iteration
    public int byKadanesAlgo(int[] nums){
        if( nums.length < 2){
            return nums[0];
        }

        int currentMax=0;
        int globalMax=nums[0];
        for(int i=0; i < nums.length ;i++){
            currentMax+=nums[i];
            if(currentMax > globalMax) globalMax=currentMax;
            if(currentMax < 0 ) currentMax=0;
        }
        return globalMax;

    }

    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();
        int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("MaxSubArray: "+obj.maxSubArray(arr));
        System.out.println("By Kadane's Algo: "+ obj.byKadanesAlgo(arr));
    }

}
