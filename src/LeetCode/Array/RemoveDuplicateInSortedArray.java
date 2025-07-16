package LeetCode.Array;

import java.util.Arrays;

public class RemoveDuplicateInSortedArray {

    public static void main(String[] args) {
        int[] arr = {-2,-1,0,0,1,1,1,2,2,3,3,3,4};

//        removeDuplicate(arr);
//        removedups(arr); //using extra of creating a result array to store unique value
        System.out.println(anotherWay(arr));
    }

    private static void removedups(int[] arr) {
        int[] result= new int[arr.length];
        int unique=arr[0];
        result[0]=arr[0];
        int j=0;
        for(int i=1; i < arr.length ;i++){
            if(arr[i] != unique ){
                j++;
                unique=arr[i];
                result[j]=unique;
            }
        }
        System.out.println("using new array: " +Arrays.toString(result));
    }


    private static void removeDuplicate(int[] arr) {
//        -2,-1,0,0,1,1,1,2,2,3,3,3,4
        if(arr.length < 2 ){
            System.out.println("Sorted : "+arr);
        }

        int unique=arr[0];
        int j=0;
        for(int i=1; i < arr.length ;i++){
            if(arr[i] != unique) {
                j++;
                unique = arr[i]; //updating the unique value
                arr[j] = unique; //adding the unique in front of the current array
            }
        }
        j=j+1;
        System.out.println("Final Sorted array: " + Arrays.toString(arr));
        System.out.println("Unique elements in the final sorted array is: "+ j);
    }

    //same logic as above but more precise and short code
    //two pointer i and j , i keep track of unique number and their last index position
    //j pointer iterate over the entire array .if unique element found
    // add the jth index element into ith index and increment ith index and counter by 1
    private static int anotherWay(int[] nums){
        int count =0; int i =0;
        if(nums.length > 0)
            count=1;
        for(int j =1 ; j< nums.length ;j++ ){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
                count+=1;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return count;
    }
}
