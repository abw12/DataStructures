package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctPairsWithDifferences {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2,6};
        int k = 3;
        int count=0;
        List<List<Integer>> pairs = new ArrayList<>();
        Map<Integer/*element*/,Integer/*index*/> map = new HashMap<>();
        for(int i=0 ; i< arr.length ; i++){
            //adding all distinct element into the hashmap
//            if(!map.containsKey(arr[i])){
//                map.put(arr[i],i); //arr element as key and its index as value
//            }
            //doing same thing as above
            map.putIfAbsent(arr[i],i);
        }
       /* a) Look for arr[i] + k in the hash map, if found then increment count.
        b) Look for arr[i] - k in the hash map, if found then increment count.
        c) Remove arr[i] from hash map*/

        for(int i=0 ; i < arr.length;i++){
            if(map.containsKey(arr[i] + k )){ //check if current element + k is present
//                count++;
                pairs.add(List.of(arr[i] + k,arr[i]));

            }
            if(map.containsKey(arr[i] - k)){
//                count++;
                pairs.add(List.of(arr[i] - k,arr[i]));

            }
            //if we want to return the pairs in the list
            map.remove(arr[i]);
        }


//        System.out.println("Distinct pair with " + k + " as a difference are "+ count);
        System.out.println("Pairs with difference " + k + " are " + pairs);


    }
}
