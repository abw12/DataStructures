package LeetCode.Strings;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] input ={"flower","flow","flush","flick"};
        System.out.println(commonPrifix(input));

    }

    private static String commonPrifix(String[] input){
        //first sort the array (the sort result is alphabatically order words and not sorted based on the length of the each word)
        Arrays.sort(input);
        String firstWord = input[0];
        String lastWord = input[input.length-1];
        int c =0;
        while(c < firstWord.length()){
            if(firstWord.charAt(c) == lastWord.charAt(c)){
                c++;
            }else {
                break;
            }
        }
            return c ==0 ? "":firstWord.substring(0,c);

    }
}
