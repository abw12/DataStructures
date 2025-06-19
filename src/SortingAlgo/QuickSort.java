package SortingAlgo;

import java.util.Arrays;

//In this quick sort example we are considering the last index of the array as pivot
//so all the values which are lower than the pivot will go at the front  of the array (beginning )
//and all the values which are higher than the pivot will go to the back end of the list
public class QuickSort {

    public static int partiton(int[] arr,int low,int high){
        int pivot =arr[high]; //consider last index of array as pivot
        int i=low-1; //this is the pointer which will fill all the values which are lower than the pivot index at front of the array ,to start with we consider it as low-1 as there is no value lower than pivot currently

            for(int j=low; j<high ; j++ ){
                if(arr[j] < pivot){
                    i++; //incrementing the pointer first where we have to add the value(ie lower values goes in front of the array)
                    //swap
                    //here we put all the lower values in the front of array
                    int temp=arr[i]; //old value
                    arr[i]=arr[j]; //put the lower value at front
                    arr[j]=temp;
                }
        }
            //now to put the pivot element at the right place in the array(right place means if the array is sorted)
            //so we were tracking with i the place where we have to move the pivot after each iteration (recursive call)
            //hence we increment the i first and then swap the pivot value
            i++;
            int temp=arr[i];
            arr[i]=arr[high];
            arr[high]=temp;

            return i; // which is our pivot index

    }

    public static void quickSort(int[] arr,int low,int high){
        //low is the starting index of the array so it must not go above the high
        if(low < high){
            //we calculate our pivot index
            int pidx = partiton(arr,low,high);

            //recursive call to break the list
            quickSort(arr,low,pidx-1);
            quickSort(arr,pidx+1,high);
        }

    }

    public static void main(String[] args) {
        int[] arr= {6,5,3,7,9,8};
        int n = arr.length-1;

        quickSort(arr,0,n);

        System.out.println("Quick Sort: "+ Arrays.toString(arr));


    }
}
