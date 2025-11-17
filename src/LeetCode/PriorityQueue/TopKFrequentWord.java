package LeetCode.PriorityQueue;

import java.util.*;

public class TopKFrequentWord {
    record Pair(String value,Integer freq){}
    private static List<String> useMinHeap(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a,b) -> {
                    if(a.freq != b.freq)
                        return Integer.compare(a.freq, b.freq); // lower frequency first since its a minHeap
                    return b.value.compareTo(a.value); // lexicographically larger first
                }
        );

        //count the freq
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for (var e : map.entrySet()) {
            minHeap.offer(new Pair(e.getKey(), e.getValue()));
            if (minHeap.size() > k) minHeap.poll();        // keep only k best so far
        }

        /* 3. extract in correct order  --------------------------------------- */
        List<String> res = new ArrayList<>(k);
        while (!minHeap.isEmpty()) res.add(minHeap.poll().value());
        Collections.reverse(res);   // heap pops “worst” of the kept items first
        return res;
    }



    private static List<String> useBucketSort(String[] words, int k) {
        int n = words.length;
        Map<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        //count the freq
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        // create a bucket array of list string of size n+1
        List<String>[] bucket = new List[n+1];
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }

        // now put the k most frequent words into the final result list from highet -> lowest
        for(int i = bucket.length-1; i > 0 && k > 0; i-- ){
            List<String> list = bucket[i];
            if(list != null){
                Collections.sort(list); //sort the list to  maintain lexicographical order of same length words
                for(String s : list){
                    if(k > 0){
                        result.add(s);
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
       String[] words = {"i","love","leetcode","i","love","coding"};
       int k = 2;
        System.out.println("Use Bucket Sort :: " + useBucketSort(words,k));
        System.out.println("Use minHeap :: "+ useMinHeap(words,k));
    }




}
