package LeetCode.Strings;

//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//Input: haystack = "hello", needle = "ll"
//        Output: 2
public class FirstOccurenceOfSubString {



    public static void main(String[] args) {
        String haystack="abhishek";
        String needle="she";

        System.out.println("Index position of first occurrence of substring:  "+findFirstOccurIndex(haystack,needle));

    }

    //brute force apporach with O(m*n) time complexity(worst-case)
    //since in the case where we find mismatch then we have to again minus it with j and reset j=0 and backtrack from there to check if we find match from with needle string again
    private static int findFirstOccurIndex(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if(needle.isEmpty() || needle.equals("")) return 0;

        int len = haystack.length() ; int i=0 , j=0 , pos=0;
        while( i < len && j < needle.length() ){
            if(haystack.charAt(i++) == needle.charAt(j)){
                j++;
            }else{
                i=i-j; //When you find a mismatch, you need to backtrack j steps to start over again and see if you can find a match from the first letter of needle.
                j=0;
                pos=i; //keep track of first index of substring
            }
        }

        return j == needle.length() ? pos : -1;

    }
}
