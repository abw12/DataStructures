package ArraysPractise.LeetCode_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

public class TopKFrequentElement {

    public static void main(String[] args) {
        int[] num ={1,2,2,4,5,6,6,7,8,8,8};
        int k = 3;
        System.out.println(findTopKthElement(num, k));

    }

    private static List<Integer> findTopKthElement(int[] num, int k) {
        int len = num.length;
//        int[] output = new int[k];
//        Map<Integer, Integer> freq = new Map.HashMap<>();
//        for (int i = 0; i < len; i++) {
//            freq.put(num[i], freq.getOrDefault(num[i], 0) + 1);
//        }
//        Map<Integer, Integer> sortedByValue = freq.entrySet().stream()
//                .sorted(Comparator.comparingInt(Map.Entry::getValue))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k1, LinkedHashMap::new));

        List<Integer>[] bucket = new List[num.length+1]; //because while filling the frquncy the numbers starts from 1 and list is o index based
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            freq.put(num[i], freq.getOrDefault(num[i], 0) + 1);
        }

        for(int key : freq.keySet()){
            int frequency = freq.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>(); //build an array of list (array index consist of list )
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int pos = bucket.length - 1; pos >= 0 && res.size() < k ; pos-- ){
            if(bucket[pos] != null){
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
