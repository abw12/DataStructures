package LeetCode.Array;


//find the product of all elements except itself at index in the given array
//solve it without using an extra space ie in O(1) time.

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    //{1,3,5,6,7}
    public static int[] productExceptSelf(int[] arr){
        int n = arr.length;
        int[]  res = new int[n];

        int left =1;
        // calculate the product of the
        for(int i=0 ; i < n ; i++){
            if(i > 0){
                left = left * arr[i-1];
            }
            res[i]=left;
        }
        //res = [1,1,5,30,180,1620,3240]
        int right =1;
        for(int i=n-1 ; i >=0 ; i--){
            if(i < n-1){
                right = right * arr[i+1];
            }
            res[i]*=right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7};
        System.out.println(Arrays.toString(productExceptSelf(arr)));


    }

}
