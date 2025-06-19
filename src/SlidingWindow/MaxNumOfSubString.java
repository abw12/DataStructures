package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxNumOfSubString {

    /**
     * Finds the frequency of the most frequently occurring substring that satisfies the given conditions.
     * The conditions are:
     * 1. The length of the substring must be within the inclusive range [minLength, maxLength].
     * 2. The number of unique characters in the substring must not exceed maxUnique.
     *
     * @param s         The input string.
     * @param minLength The minimum length of the substring.
     * @param maxLength The maximum length of the substring.
     * @param maxUnique The maximum number of unique characters allowed in a substring.
     * @return The frequency of the most frequently occurring substring that meets the conditions.
     */
    public static int maxFrequency(String s, int minLength, int maxLength, int maxUnique) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        int maxFreq = 0;
        int n = s.length();

        // We only need to consider substrings of length minLength.
        // If a longer substring is valid and occurs k times, any substring of length minLength
        // within it at the same starting position will also be valid.
        // The maximum frequency will be determined by the frequencies of valid substrings of length minLength.

        // Use a sliding window of size minLength
        Map<Character, Integer> uniqueCharCount = new HashMap<>();
        int uniqueCount = 0;

        // Initialize the first window of size minLength
        for (int i = 0; i < minLength; i++) {
            char c = s.charAt(i);
            uniqueCharCount.put(c, uniqueCharCount.getOrDefault(c, 0) + 1);
            if (uniqueCharCount.get(c) == 1) {
                uniqueCount++;
            }
        }

        // Process the first window
        if (uniqueCount <= maxUnique) {
            String sub = s.substring(0, minLength);
            frequencyMap.put(sub, frequencyMap.getOrDefault(sub, 0) + 1);
            maxFreq = Math.max(maxFreq, frequencyMap.get(sub));
        }

        // Slide the window of size minLength across the string
        for (int i = minLength; i < n; i++) {
            // Add the new character to the window
            char charToAdd = s.charAt(i);
            uniqueCharCount.put(charToAdd, uniqueCharCount.getOrDefault(charToAdd, 0) + 1);
            if (uniqueCharCount.get(charToAdd) == 1) {
                uniqueCount++;
            }

            // Remove the character leaving the window
            char charToRemove = s.charAt(i - minLength);
            uniqueCharCount.put(charToRemove, uniqueCharCount.get(charToRemove) - 1);
            if (uniqueCharCount.get(charToRemove) == 0) {
                uniqueCount--;
            }

            // Check the current window
            if (uniqueCount <= maxUnique) {
                String sub = s.substring(i - minLength + 1, i + 1);
                frequencyMap.put(sub, frequencyMap.getOrDefault(sub, 0) + 1);
                maxFreq = Math.max(maxFreq, frequencyMap.get(sub));
            }
        }

        return maxFreq;
    }


    public static void main(String[] args) {
        // The HackerRank environment will handle input and output.
        // You can add your test cases here for local testing.
        // Example Usage:
         String s = "aababcaab";
         int maxLetters = 2;
         int minSize = 3;
         int maxSize = 4;
         System.out.println(maxFrequency(s, minSize, maxSize, maxLetters)); // Expected output: 2

         String s2 = "aaaa";
         int maxLetters2 = 1;
         int minSize2 = 3;
         int maxSize2 = 3;
         System.out.println(maxFrequency(s2, minSize2, maxSize2, maxLetters2)); // Expected output: 2
    }
}
