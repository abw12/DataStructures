package ArraysPractise;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int checkForSingleNumber(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i < arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1); //checking if the key in the map exist or not , if not return default 0 +1
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }

    //checking the first appearance of the single value in the given array
    public static void main(String[] args) {
    int[] arr={4,1,2,1,4,5,8};
    SingleNumber obj =new SingleNumber();
    System.out.println(Integer.toString(obj.checkForSingleNumber(arr)));
    }
}
