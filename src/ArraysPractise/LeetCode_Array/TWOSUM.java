package ArraysPractise.LeetCode_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TWOSUM {

    //better approach to solve this prob with O(n) time complexity
    public static int[] twoSum(int[] num, int target){
        int[] ans =new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < num.length ; i++){
            if(map.containsKey(target - num[i])){
                ans[1]=num[i]; //if want to return the value and not indices of two numbers then wrap them like this
                ans[0]=num[map.get(target - num[i])];
                return ans;  //we are returning the indexes of the  value in the array whose sum = target
            }
            map.put(num[i],i);  //value in the array is key and position on which it appears in array is the value of the map
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,6,7,1};
        int target =3;

        System.out.println(Arrays.toString(twoSum(arr,target)));



    }
}
