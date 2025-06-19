package LeetCode_String;

/*1. Given an array of strings. For each string, return the least number of characters to be modified so that there are
NO consecutive identical characters in any string. All strings are non-empty and contain only lowercase English letters a-z.

        Example :
        ab - 0 changes needed as there are no two identical consecutive characters in this string
        aaa - change the middle a to something else - so just 1 modification needed
        aaaab - change either first and third 'a' to something else, or else change 2nd and 4th 'a' to something else - 2 modifications needed
        aaacc - change middle 'a' to something else and change one of the 'c' to something else - so just 2 modifications needed
        aaaaabbbcc - change 2nd and 4th 'a', change middle 'b' and change any one of the 'c' - total 4 modifications needed*/


import java.util.Arrays;

public class JpMorganTest1 {
    public static void main(String[] args) {
        String[] input = {"ab","aaa","aaaab","aaacc","aaaaabbbcc","abbabaacxxzzyy"};



        for(int i =0 ;i < input.length ; i++){
            int modification=0;
            String[] s = input[i].split("");
            for(int j =1 ; j < s.length ;j++){
                if(s[j].equals(s[j-1])){
                    s[j]="#";
                    modification++;
                }
            }
            System.out.println("Modification needed: "+ modification);
            System.out.println("After Modification: " + Arrays.toString(s));
        }
    }

}
