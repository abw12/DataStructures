package ArraysPractise;

import java.util.Arrays;

//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
// The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//Increment the large integer by one and return the resulting array of digits.
public class PlusOneLeetCode {

    public static int[] plusOne(int[] digits){
        int len = digits.length;
        for(int i=len-1 ;i >=0 ;i--){
            if(digits[i] < 9){
                digits[i]++; //we look for first appearence of non 9 digit and just increment it by 1 and return the array
                return digits;
            }
            digits[i]=0;
        }
        int[] newArr=new int[len+1]; // if its all 9's in the array than we have create new array incremented by length + 1 ,
        // and just add first index as 1 since all othe index will be zero already in new array
        newArr[0]=1;
        return newArr;
    }

    public static void main(String[] args) {
        int[] digits={9,9};

        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
