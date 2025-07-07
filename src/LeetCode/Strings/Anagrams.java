package LeetCode.Strings;

import java.util.Arrays;

public class Anagrams {

    public static boolean isAnagram(String str1 ,String str2){
        if(str1.length() != str2.length())
            return false;

        String s1 = str1.replaceAll("\\s","");
        String s2 = str2.replaceAll("\\s","");

        char[] s1Arr=s1.toLowerCase().toCharArray();
        char[] s2Arr=s2.toLowerCase().toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        return Arrays.equals(s1Arr, s2Arr);
    }

    //this solution is using the ascii table value approach
    //time complexity is same as sort method
    private static boolean leetCodeAnagram(String s, String t){

        if( s.length() != t.length()) return false;

        //one way by using sort method (Arrays.sort() method take O(n log n) Time in worst case)
        //
        //         char[] sArr = s.toCharArray();
//         char[] tArr = t.toCharArray();

//         Arrays.sort(sArr);
//         Arrays.sort(tArr);
//         for(int i=0 ; i < s.length() ; i++){
//             if(sArr[i] != tArr[i]){
//                 return false;
//             }

//         }

        int[] sArr = new int[256]; //size is 256 to support all ascii table value characters
        int[] tArr = new int[256];

        for(int i =0 ; i < s.length() ; i++){
            sArr[s.charAt(i) - 'a']++;
        }

        for(int i =0 ; i < t.length() ; i++){
            tArr[t.charAt(i) - 'a']++;
        }

        for(int i=0 ; i < s.length() ; i++){
            if(sArr[s.charAt(i) - 'a'] != tArr[s.charAt(i) - 'a']){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String str1="keep";
        String str2="peek";

        String s="anagram";
        String t="nagaram";

        System.out.println("Strings are Anagrams : "+isAnagram(str1,str2));
        System.out.println("Leetcode question: " + leetCodeAnagram(str1,str2));
    }
}
