package SortingAlgo;

import java.util.Arrays;

public class BinaryArraySort {

//    They exploit the tiny key space (just {0,1}),
//    giving O(n) time and O(1) space—strictly better than any comparison sort’s Ω(n log n)
//    lower bound.
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0,1,0,1};

        //using the counting sort technique
        // first iterate and through all zero and count them. Then iterate through
        // entire array and add the zero at front till zero counter then just add 1st in remaining places
        // time= o(n) and space is o(1)
        int count_zero=0;
        for(int n : arr){
            if(n == 0) count_zero++;
        }
        for(int i=0; i < arr.length;i++){
            arr[i]=(i < count_zero) ? 0 : 1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
