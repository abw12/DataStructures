package ArraysPractise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    //naive approach with time complexity of O(n^2)
    public static void rotate(int[] arr,int shift){

        if(shift>0 && shift<= arr.length ){

            for(int i=0 ; i < shift; i++){
                int j= arr.length- 1; // for right shift start from last index
//                int j=0; //for left shift start from first index
                int temp=arr[j];
                for(;j > 0 ;j--){     //for left shift this will change to the positive increment wiht j < arr.length
                    arr[j]=arr[j-1];
                }
                arr[0]=temp;  // to put the last index value at first position in right shift
            }
            System.out.println("Reversed array: "+ Arrays.toString(arr));
        }else{
            System.out.println("Invalid input");
        }
    }


    public static void rotateArrayBetter(int [] arr ,int k) {
        int len = arr.length;
        //since we use mod now to calculate mid element (storing into k variable only) in array
        // from where we will divide the array into parts and to reverse operations
        //below if condition is commented out
//        if (k < 0 && k >= len)
//            throw new IllegalArgumentException("Illegel Argument");

//        below line of code does not work to calculate the mid if k(k) > length of array
//        int divide= len - k;
        //hence to make sure k(k) will always remain within the range of our array indices we use below calculation of modules
        k = k % len;

        //to do right rotation
        //first rotate entire array 0 to len-1 , then o to k-1 and finally k to len-1;
        reverse(arr,0,len-1);
        reverse(arr,0,k-1);
        reverse(arr,k,len-1);

        //to do the left shift , 1st reverse 0 to k-1 ,then k to len-1 and finally 0 to len-1
//        reverse(arr,0,k-1);
//        reverse(arr,k,len-1);
//        reverse(arr,0,len-1);


        System.out.println("Better approach :"+ Arrays.toString(arr));

    }
    public static void reverse(int[] arr,int left ,int right){
        if(arr.length == 0)
            System.out.println("error...length of array");

        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,7};
        List<String> newList = new ArrayList<>();
        int shift=3;
//        rotate(arr,shift);
        rotateArrayBetter(arr,shift);

    }

}
