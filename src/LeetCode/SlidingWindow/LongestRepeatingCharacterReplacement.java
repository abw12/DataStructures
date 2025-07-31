package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    private static int characterReplacement(String s,int k) {
        Map<Character,Integer> freq = new HashMap<>();
        int maxLength=0, maxFreq=0,l=0;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            // add the current character to the frequency map
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, freq.get(ch));
            // if the current window size minus the most frequent character count is greater than k, we
            // need to shrink the window from the left
            if((r-l+1) - maxFreq > k){
                freq.put(s.charAt(l),freq.get(s.charAt(l))-1);
                l++;
            }
            maxLength = Math.max(maxLength, (r-l+1));
        }
        return maxLength;
    }
    // This approach works similarly to the above but uses a bucket sort technique
    // to keep track of the frequency of characters in the current window.
    // Its faster in the leetcode runtime environment.
    // Time complexity is O(n) and space complexity is O(1) since we are using a fixed size array of 26 for the alphabet.
    // similar to approach used above
    private static int usingBucketSort(String s, int k){
        int[] bucket = new int[26]; // for 26 letters in the alphabet
        int maxFreq =0, maxLen = 0, l = 0;
        for(int r = 0; r < s.length(); r++){
            bucket[s.charAt(r)- 'A']++; // increment the frequency of the current character
            maxFreq = Math.max(maxFreq, bucket[s.charAt(r) - 'A']);
            // if the current window size minus the most frequent character count is greater than k, we
            // need to shrink the window from the left
            if((r - l + 1) - maxFreq > k){
                bucket[s.charAt(l) - 'A']--; // decrement the frequency of the left character
                l++; // move the left pointer
            }
            maxLen = Math.max(maxLen, r - l + 1); // update the maximum length of the window
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k=1;
        System.out.println(characterReplacement(s,k));
        System.out.println(usingBucketSort(s,k));
    }


}
