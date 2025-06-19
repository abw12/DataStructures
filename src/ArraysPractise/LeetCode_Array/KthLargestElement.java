package ArraysPractise.LeetCode_Array;

import java.util.Arrays;

public class KthLargestElement {


    //this is the naive approach
    //optimal solution to this problem is using Priority Queue using (min heap) ,check the Priority Queue folder
    //this method is using insertion sort to sort the array first therefore it takes the O(n^2) in worst case scenario and O(n) if the array is almost sorted

    public static int kthLargest(int[] nums, int k){
       int len = nums.length;

       int j;
       for(int i=1;i < len;i++){
           j=i;
           while((j > 0 ) && (nums[j-1] > nums[j] ) ) {
               int temp = nums[j];
               nums[j] = nums[j - 1];
               nums[j - 1] = temp;
               j--;
           }
       }

       System.out.println(Arrays.toString(nums));

        return nums[len-k];
    }

    public static void main(String[] args) {
        int[] arr ={2,3,2,4,5,6,7,10,17};
        int k=3; //should return the kth largest element from given array

        System.out.println(kthLargest(arr,k));

    }
}
