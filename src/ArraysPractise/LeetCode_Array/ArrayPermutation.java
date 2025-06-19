package ArraysPractise.LeetCode_Array;

import java.util.Arrays;

//Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
//
//        A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).

//<=============================================================================>

//Since we are editing the array in-place, we need to find a way to have both old and new values coexist, and retrieve them easily. We achieve this by combining *, / and % operators.
//
//        First iteration
//        We want to build a transitory array where each element looks like this: new * n + old. This enables us to store both old and new information at the same place. We cannot override the old information with the new yet, since we need it to build the new.
//
//        For example: [0, 2, 1] --> transitory array [0, 2 + 1 * n, 1 + 2 * n]
//
//        When we iterate over the array, since we are updating the array in-place, nums[nums[i]] may yield an element which is already in the form new * n + old. Since we want the old value, we retrieve it with %.
//
//        For example, with the same array: if we didn't use % we would have [0, 2 + 1 * n, 1 + (2 + 1 * n) * n]
//
//        Second iteration
//        Now that we've got our transitory array, we can retrieve the new value with /

//to solve this question with O(1) space complexity & O(n) time complexity we can follow above approach
public class ArrayPermutation {

    public static  int[] BuildArray(int[] nums) {
//        try{
//            int l = Integer.parseInt("abc");
//        }catch(NullPointerException x){
//
//        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += (nums[nums[i]] % n) * n;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }
        return nums;


    }



    public static void main(String[] args) {
        int[] input = {0,2,1};
        System.out.println(Arrays.toString(BuildArray(input)));
    }


}
