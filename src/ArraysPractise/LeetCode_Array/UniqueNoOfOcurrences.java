package ArraysPractise.LeetCode_Array;

import java.util.*;

//this algo takes O(n) time = O(n) to iterate through input for creating map + O(n) to insert map values into hashset (map.values() method)
// O(n) + O (n) = 2 O(n)  => O(n) simplified
public class UniqueNoOfOcurrences {

    public static void main(String[] args) {
        int[] input = {1,2,2,2,3,1,1,4,4,4,4};

        System.out.println(isArrayUniqueCompact(input));
    }

    private static Boolean isArrayUnique(int[] arr) {
        Map<Integer,Integer> occurrences = new HashMap<>();
        for(int i=0; i< arr.length;i++){
            if(occurrences.containsKey(arr[i])){
                occurrences.put(arr[i],occurrences.get(arr[i])+1);
            }else{
                occurrences.put(arr[i],1);
            }
        }
        System.out.println(occurrences);
        Iterator<Integer> iterator = occurrences.values().iterator();
        Set<Integer> uniqueNum = new HashSet<>();
        while(iterator.hasNext()){
            uniqueNum.add(iterator.next());
        }
        if(uniqueNum.size()!= occurrences.size()){
            return false;
        }
        return true;
    }

    //this method is doing same thing only in less number of lines
    //this algo takes O(n) time complexity
    //time complexity of few methods of hashmap
    //remove: O(1)
    //size: O(1)
    //values: O(n) (on traversal through iterator)
    private static boolean isArrayUniqueCompact(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return map.size() == new HashSet<>(map.values()).size(); //this is how you can enter the map.values() into the new hashSet
        //set will not include the repeated values

    }

}
