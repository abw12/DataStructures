package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;


/*You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.*/

/*Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

Constraints:
1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length*/
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
    // (since there are only 26 uppercase english letters so this approach works better than using hashmap)
    // It's faster in the leetcode runtime environment.
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
