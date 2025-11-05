package SortingAlgo;

import java.util.Arrays;

//this takes O(n logn) time complexity and O(n) space complexity
public class MergeSort {

    public void conquer(int[] arr,int si, int mid,int ei){
        int[] mergedArray = new int[ei-si +1]; // new empty array to hold out merged list this is why merge sort take O(n) space complexity

        int idx1 = si; //this index 1 will keep track of first part(left part ) of array while merging
        int idx2 = mid +1; //this index 2 will keep track of second part(right part) of array while merging
        int x=0;

        //this merging takes O(n) time
        while(idx1 <=mid && idx2 <=ei){
            if(arr[idx1] <= arr[idx2]){
                mergedArray[x++]=arr[idx1++];
            }else{
                mergedArray[x++]=arr[idx2++];
            }
        }
        //this loop is to fill remaining index from first part of array(left part)
        // if some extra elements are remaining (as they are already sorted we can put them as it in out mergedArray
        while(idx1 <= mid ){
            mergedArray[x++] = arr[idx1++];
        }
        //this loop is to fill remaining index from second part of array(right part)
        // if some extra elements are remaining (as they are already sorted we can put them as it in out mergedArray
        while(idx2 <= ei ){
            mergedArray[x++]=arr[idx2++];
        }
        //copying all elements from mergedArray into our original array
        //mergedArray length will increase as  keep merging the elements
        for(int i=0 ,j=si; i < mergedArray.length;i++,j++){
            arr[j]=mergedArray[i];
        }

    }


    //this divide approach takes O(log n) time
    public void divide(int[] arr,int si, int ei){
        //base case for recursive will be
        if(si >= ei) //starting and ending index is same then return from that method
            return;


        int mid = si + (ei - si)/2; //we can do this as (si-ei)/2 but its not ideal when the index's are larger suppose eg: si=4002 ei=89990
        //we will keep dividing  our array into half until we get single value in an array
        divide(arr,si,mid); //this will divide the left part of the array till single value in sa array
        divide(arr,mid+1,ei); //this will divide the right part of the array till the single value in a array
        conquer(arr,si,mid,ei);

    }


    public static void main(String[] args) {

        MergeSort mergeSort= new MergeSort();

        int[] arr = {6,5,9,7,1,-2,-1,10};
        int len = arr.length-1;

        mergeSort.divide(arr,0,len);
        System.out.println("Merged Sort Array: "+Arrays.toString(arr));


    }
}
