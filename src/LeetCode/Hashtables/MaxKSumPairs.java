package LeetCode.Hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxKSumPairs {

    // Time = O(n log(n)) because of the sort operation
    // Space = O(1) no extra space used
    // good enough but not faster than 2nd approach
    private static int useSortingWithTwoPointer(int[] nums, int k){
        //sort the array
        Arrays.sort(nums);
        // [1,3,3,3,4]
        // [3,1,3,4,3],
        //now use two-pointer to find the sum and check if equals to k
        int left = 0;
        int right = nums.length-1;
        int maxOps=0;
        while(left < right){
            int curr_sum = nums[left] + nums[right];
            if(curr_sum == k){
                left++;
                right--;
                maxOps++;
            }else if(curr_sum < k){
                left++;
            }else{
                right--;
            }
        }
        return maxOps;
    }

    // Time = O(n) linear operation. faster than the first approach
    // Space = O(n) use extra space to store num in map
    private static int useHashMap(int[] nums, int k){
        int maxOps=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            int compliment = k - num; //to find the pair decrement the k with current iteration num
            if(map.containsKey(compliment) && map.get(compliment) > 0 ){
                maxOps++;
                map.put(compliment,map.get(compliment)-1); //decrement the other number by 1 since we have paired it with the current number
            }else{
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return maxOps;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,3,3,4};
        int k=6;
        System.out.println(useHashMap(nums,k));
        System.out.println(useSortingWithTwoPointer(nums,k));
    }
}
