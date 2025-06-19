package DesignPatterns;


import java.util.Arrays;

//User gives You have an array, it’s an int array, it is 0-9.
//Right shift the array “K” times where k=3, Input = 0,1,2,3,4,5,6,7,8,9 and Output should be = 7,8,9,0,1,2,3,4,5,6
public class Test {


    public static void main(String[] args) {
        int[] arr= {0,1,2,3,4,5,6,7,8,9};
        int k=3;
        int n = arr.length;
        k = k % n;

        swap(arr,0,n-1); //0,1,2,3,4,5,6,7,8,9 => 9,8,7,6,5,4,3,2,1,0
        swap(arr,0,k-1); // 9,8,7,6,5,4,3,2,1,0 => 7,8,9,6,5,4,3,2,1,0
        swap(arr,k,n-1); // 7,8,9,6,5,4,3,2,1,0 => 7,8,9,0,1,2,3,4,5,6

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int start, int end){
        while (start <= end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }





}
