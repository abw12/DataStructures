package LeetCode.BinarySearch;

import java.util.Arrays;

public class SearchRange {

    /*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.*/

//    {2,3,4,4,6,6,6,6,6,7,8}
    private static int[] searchRange(int[] nums , int target){
        int len =nums.length;
        int l = 0;
        int r = len-1;
        int first=-1; // index position for first appeared element
        int last=-1; //index position for last appeared element

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                first=mid;
                last=mid;

                while(first > 0 && nums[first] == nums[first-1]){
                    first--;
                }
                while(last < len-1 && nums[last] == nums[last+1]){
                    last+=1;
                }
                break;
            }else if(nums[mid] < target){
                l+=1; //incrementing the left pointer by 1
            }else{
                r-=1; //decrementing the right pointer by 1
            }
        }
        return new int[]{first,last};
    }



    public static void main(String[] args) {
       int[] arr = new int[]{2,3,4,4,6,6,6,6,6,7,8} ; int target = 6;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}
