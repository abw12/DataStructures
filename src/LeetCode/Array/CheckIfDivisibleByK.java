package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class CheckIfDivisibleByK {

    //This approach beats 58% runtime in leetcode so slighty slower than the 2nd one which uses arr to keep freq of remainders
    private static boolean useHashMapForFreq(int[] arr,int k){
//         create and maintain hashmap where key = remainder, value = frequency of remainder
         Map<Integer,Integer> map = new HashMap<>();
         for(int n : arr){
             int rem = n % k; //give us the remainder
             if(rem < 0)
                 rem= rem+k; //since modulo operation in java gives use remainder in negative as well we have to put this condition to make the raminder positive

             map.put(rem,map.getOrDefault(rem,0)+1); //count the frequency of same remainder for each numbers
         }
         //iterate over the map
         for(Map.Entry<Integer,Integer> entry: map.entrySet()){
             int rem = entry.getKey();
             int count = entry.getValue();
             if(rem == 0){
                 if(count % 2 !=0) //special case if the rem=0 count is not even that means we couldn't form the pairs correctly
                     return false;
             }else{
                 int complement = k - rem;
                 if(count != map.getOrDefault(complement,0))
                     return false;
             }
         }
         return true;
    }

    //use the k-size array to store the freq of the remainder for each number in the given array
    // array index represents the remainder and the value store in those index is its frequency(count)
    private static boolean useArrayForFreq(int[] arr,int k){
        int[] freq = new int[k]; //index represent the remainder and the value represents its frequency
        for(int n: arr){
            int rem = n % k;
            if(rem < 0)
                rem=rem+k; //since modulo operation in java gives use remainder in negative as well we have to put this condition to make the remainder positive
            freq[rem]++;
        }

        if(freq[0] % 2 != 0){ ////if rem=0 count is not even then return false since we can't form the pairs
            return false;
        }
        for(int i=1; i <= k/2;i++){
            if(freq[i] != freq[k-i]){ // current iteration rem count and its complement remainder count should be same (similar to the map used above)
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;

        System.out.println(useHashMapForFreq(arr,k));
        System.out.println(useArrayForFreq(arr,k));
    }
}
