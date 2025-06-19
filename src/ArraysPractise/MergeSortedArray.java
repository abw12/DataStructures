package ArraysPractise;

import java.util.Arrays;

public class MergeSortedArray {

    //here the first array is size of m + n length  where remaining elements which need to be merged from arr2 are kept as o at start
    //ege arr1 = [1,2,3,0,0,0] m=3
    //    arr2 = [4,5,6] n=3
    //merged = [1,2,3,4,5,6]
    public static void leetCodeMergedArr(int[] arr1 , int m , int[] arr2 ,int n ){
        int p1=m-1; //last index of the 1st array where we have non-zero value
        int p2=n-1; //last index of the second array
        int i=m+n-1; //last index of the entire array
        while(p2>=0){
            if(p1>=0 && (arr1[p1] > arr2[p2])){
                arr1[i--]=arr1[p1--];
            }else{
                arr1[i--]=arr2[p2--];
            }
        }

        System.out.println("leetcode Merged Array: " + Arrays.toString(arr1));

    }


    //here in this method we are using extra space of O(n) for mergedArr
    public static void mergeTwoArray(int[] arr1,int[] arr2){
        if(arr1.length == 0 && arr2.length == 1 ){
            System.out.println(arr2[0]);
        }else if(arr1.length == 1 && arr2.length ==0 ){
            System.out.println(arr1[0]);
        }

        //we are storing the merged numbers into a seperate array
        int[] mergedArr = new int[arr1.length + arr2.length];
        int i=0; //this pointer will represent arr1
        int j=0; //this pointer will represent arr2

        for(int k=0 ; k < mergedArr.length ; k++){
//            if(i== arr1.length || (j != arr2.length && arr2[j] < arr1[i])){
//                mergedArr[k]=arr2[j++];
//            }else{
//                mergedArr[k]=arr1[i++];
//            }
            if( i != arr1.length && ( j == arr2.length || arr1[i] < arr2[j])){
                mergedArr[k]=arr1[i++];
            }else{
                mergedArr[k]=arr2[j++];
            }
        }

        System.out.println("Merged Array: "+ Arrays.toString(mergedArr));

    }


    public static void main(String[] args) {
        int[] arr1 = {0,2,3,4,7,8};
        int[] arr2 = {1,5,6,9};

        mergeTwoArray(arr1,arr2);

        //this is the leetcode merge sorted array question which is different than the above question
        int[] a = {0,2,3,4,7,8,0,0,0,0};
        int[] b = {1,2,6,9};
        int m=6;
        int n=4;
        leetCodeMergedArr(a,m,b,n);


    }

}
