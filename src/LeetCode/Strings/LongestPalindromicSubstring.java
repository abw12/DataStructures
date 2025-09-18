package LeetCode.Strings;

public class LongestPalindromicSubstring {

   /* Given a string s, return the longest palindromic substring in s.



    Example 1:

    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
            Example 2:

    Input: s = "cbbd"
    Output: "bb"


    Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letters.*/
    private static String longestSubstring(String s){
        if(s == null || s.isEmpty()){
            return "";
        }

        int start=0,end=0;
        //babad
        for(int i=0; i< s.length();i++){
            int odd = expandAroundCentre(s,i,i); //find the length of the odd length palindromic string
            int even = expandAroundCentre(s,i,i+1); //find the length of the even length palindromic string
            int max_len = Math.max(odd,even);

            if (max_len > end-start){
                start = i - (max_len-1)/2;
                end = i + max_len/2;
            }
        }
        return s.substring(start,end+1); //doing end+1 since substring method endIndex is exclusive
    }

    private static int expandAroundCentre(String s, int left,int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s= "babad";
        System.out.println("Longest Palindromic substring is :: " + longestSubstring(s));
    }
}
