package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        System.out.println(findLongestConsecutiveSequence(nums));

    }
    private static int findLongestConsecutiveSequence(int[] nums){
        if(nums.length == 0 ) return 0;

        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n); //populate the set with input values(this will ignore the duplicate values
        }
        for(int n : nums){

            int left = n - 1; // substracting the value by 1 from the current number in input array
            int right = n + 1; // adding the value by 1 from the current number in input array
            int count = 1; //its 1 since we are counting the current element itself
            //check if previous number to the current element exist in set or not
            while (set.contains(left)){
                set.remove(left); //after matching the value in set we should remove the current element so that we don't recount that value again
                count++;
                left--;
            }
            //check if next number to the current element exist in set or not
            while(set.contains(right)){
                set.remove(right);
                count++;
                right++;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}
