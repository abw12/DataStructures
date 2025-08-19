package LeetCode.Strings;

public class LongestPalindromicSubstring {

    private static String longestSubstring(String s){
        if(s == null || s.isEmpty()){
            return "";
        }

        int start=0,end=0;

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
