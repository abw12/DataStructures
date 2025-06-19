package SortingAlgo;

import java.util.Arrays;

public class InsertionSort {

    public static void sortAsc(int[] nums){
        int j;

        for(int i=1; i < nums.length;i++){
             j=i;
             //we only keep swaping if the left number is larger than the right number therefore this part of insertion sort
            // make it more faster if the given input array is almost sorted
            while((j > 0) && (nums[j-1] > nums[j])){
                int temp=nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] input = {5,3,2,8,9,7,6,1};

        sortAsc(input);

    }
}
