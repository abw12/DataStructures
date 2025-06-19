package ArraysPractise.LeetCode_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumberThanCurrent {

    //How Many Numbers are smaller than the current Number
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static  int[] smallerNumbersThanCurrent(int[] nums) {
        //brute force approach with O(n^2) Time

        // int[] result = new int[nums.length];
        // for(int i=0 ; i < nums.length;i++){
        //     for(int j=0 ; j < nums.length;j++){
        //         if(i!=j && nums[j] < nums[i]){
        //             result[i]+=1;
        //         }
        //     }
        // }
        // return result;

        //Better solution using map with O(n) time
        Map<Integer/*element*/,Integer/*no. of smaller elements*/> map = new HashMap<>();
        int[] copy = nums.clone();

        Arrays.sort(copy);
        //1,2,2,3,8

        for(int i=0 ; i < nums.length;i++){
            map.putIfAbsent(copy[i],i); //key is value of sorted array , and value is index of sorted array (ignore duplicate element from array)
        }

        for(int i=0 ; i < nums.length;i++){
            copy[i]=map.get(nums[i]); //entering the final count of values in same position as values appreared in OG array
        }

        return copy;
    }
}
