package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindNegativeIntegerInSlidingWindow {

    public static void main(String[] args) {
        int[] arr = {12, 1, -7, 8, -15, 30 , 16, -28};
        int k =3 ;
        int n = arr.length;

        System.out.println("Naive Approch : " + naiveApproch(arr,n,k));
        System.out.println("Optimised Approch:  " + optimisedApproch(arr,n,k));
    }

    private static List<Integer> naiveApproch(int[] arr,int n,int k){
        List<Integer> result = new ArrayList<>();
        boolean flag;
        for(int i=0;i < (n - k + 1) ; i++){
            //wrong condition fails other test cases ( i tried in the HERE Tech. interview)
//            if(i == arr.length - k) {
//                result.add(0);
//                break;
//            }
            flag = false;
            // if a negative integer is found, then
            // it is the first negative integer for
            // current window. add it to result , set the flag
            // and break
            for(int j=0 ; j < k  ; j++){
                if(arr[i+j] < 0){
                    result.add(arr[i+j]);
                    flag=true;
                    break;
                }

            }
            if(!flag){
                result.add(0);
            }
        }

        return result;
    }



    private static List<Integer> optimisedApproch(int[] arr, int n ,int k) {
        List<Integer> result = new ArrayList<>();
        //{12, 1, -7, 8, -15, 30 , 16, -28}
        int firstNegativeIndex =0;
        int firstNegativeElement;

        for(int i = k - 1 ; i < n ; i++ ){

            while((firstNegativeIndex < i) &&
                    (firstNegativeIndex <= i - k || arr[firstNegativeIndex] >=0 )){
                firstNegativeIndex++;
            }

            if(arr[firstNegativeIndex] < 0){
                firstNegativeElement=arr[firstNegativeIndex];
                result.add(firstNegativeElement);
            }else{
                firstNegativeElement=0;
                result.add(firstNegativeElement);
            }

        }
        return result;
    }

}
