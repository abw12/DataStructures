package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containDuplicate(int[] nums){
        //time complexity is O(n^2) not good
        //  for(int i=0;i < nums.length;i++){
        //      for(int j=i+1;j < nums.length;j++){
        //          if(nums[i] == nums[j]){
        //              return true;
        //          }
        //      }
        //  }
        // return false;

        //O(n) time complexity
        Set<Integer> set =new HashSet<Integer>();
        for(int i : nums){
            if(!set.add(i)){ //since add method return false if the value is already present in the hashset
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num= {1,2,3,4,5,4};

        System.out.println(containDuplicate(num));
        System.out.println(containDup(num));

    }

    //practise
    public static int containDup(int[] arr){
        Set<Integer> uniqueNum= new HashSet<>();
        for(int i =0 ; i < arr.length ; i++){
            if(!uniqueNum.add(arr[i])){
                return arr[i];
            }
        }
        return -1;
    }




}
