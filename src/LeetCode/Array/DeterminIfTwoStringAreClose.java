package LeetCode.Array;

import java.util.Arrays;

public class DeterminIfTwoStringAreClose {

    private static boolean compareString(String word1,String word2){
        // condition1 - both strings length should match
        if(word1.length() != word2.length()) return false;

        //count the freq of character for both string
        int[] freq1= new int[26];
        int[] freq2= new int[26];

        for(char ch: word1.toCharArray())
            freq1[ch - 'a']++;

        for(char ch:word2.toCharArray())
            freq2[ch - 'a']++;

        //condition 2 - should contain same set of characters
        // Only the non-zero entries matter; log 26 ≈ constant, so still O(1) extra time.
        for(int i=0; i < 26 ;i++){
            if((freq1[i] == 0 ) != (freq2[i] == 0)){
                return false;
            }
        }
        //condition 3 - should have same frequency of characters
        // sort the frequency array and compare
        // if the frequency of characters are same then both the frequency array will be same after sorting
        Arrays.sort(freq1);
        Arrays.sort(freq2);
//        for(int i=0; i < 26 ;i++){
//            if(freq1[i] != freq2[i]){
//                return false;
//            }
//        }
//        return true;
        // if not using the below equals method then it can be written as above condition
        return Arrays.equals(freq1,freq2);
    }


    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";

        System.out.println(compareString(word1,word2)
        );
    }
}
