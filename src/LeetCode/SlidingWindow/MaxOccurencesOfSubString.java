package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurencesOfSubString {

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //track and count the unique characters in a substring
        Map<Character,Integer> distCharMap = new HashMap<>();
        //track and count the frequency of the substring for maxFreq count
        Map<String,Integer> freqmap = new HashMap<>();
        // counter for unique char and maxFreq of substring
        int unqiueChar = 0;
        int maxFreq = 0;
        // process first fixed window (till minSize)
        for(int i =0; i < minSize;i++){
            char charToAdd = s.charAt(i);
            distCharMap.put(charToAdd, distCharMap.getOrDefault(charToAdd,0)+1);
            if(distCharMap.get(charToAdd) == 1){
                unqiueChar++;
            }
        }
        // add the substring to freqmap and increment the maxFreq counter
        if(unqiueChar <= maxLetters){
            String subString = s.substring(0,minSize);
            freqmap.put(subString,freqmap.getOrDefault(subString,0)+1);
            maxFreq=Math.max(maxFreq,freqmap.get(subString));
        }
        //Now iterate over from minSize to length of the s string
        for(int r = minSize; r < s.length(); r++){
            //add the character coming in the window from right side(right pointer)
            char charToAdd = s.charAt(r);
            distCharMap.put(charToAdd,distCharMap.getOrDefault(charToAdd,0)+1);
            if(distCharMap.get(charToAdd) == 1)
                unqiueChar++;

            //substract the character going out of the window(left pointer charToRemove)
            char charToRemove = s.charAt(r-minSize);
            if(distCharMap.containsKey(charToRemove)){
                distCharMap.put(charToRemove,distCharMap.get(charToRemove)-1);
                if(distCharMap.get(charToRemove) == 0)
                    unqiueChar--;
            }

            // fetch the substring now based on r-l+1
            if(unqiueChar <= maxLetters){
                String subString = s.substring(r-minSize+1,r+1); //adding +1 since array is 0th index based and we are not keeping track of left pointer in this solution so calculating on the go the validfixed window size
                freqmap.put(subString,freqmap.getOrDefault(subString,0)+1);
                maxFreq=Math.max(maxFreq,freqmap.get(subString));
            }
        }
        return maxFreq;
    }

    public static void main(String[] args) {
        String s = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;

        System.out.println(maxFreq(s, maxLetters, minSize, maxSize));
    }
}
