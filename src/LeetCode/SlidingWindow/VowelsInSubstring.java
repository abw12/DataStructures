package LeetCode.SlidingWindow;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VowelsInSubstring {
    private static int maxVowels(String s, int k) {
        // create  set of vowels
        Set<Character> vSet = new HashSet<>(List.of('a','e','i','o','u'));
        int currV = 0;
        //iterate on fixed size of windows till k
        for(int r=0; r < k ;r++){
            if(vSet.contains(s.charAt(r))){
                currV++;
            }
        }
        int maxV = currV;
        // now iterate over remaining characters till end of string
        for(int r = k; r < s.length(); r++){
            int l = r - k;
            //left element substracting from the window
            if(vSet.contains(s.charAt(l))){
                currV--;
            }
            //right element adding to the window
            if(vSet.contains(s.charAt(r))){
                currV++;
            }
            maxV = Math.max(maxV,currV);
        }
        return maxV;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

}
