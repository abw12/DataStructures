package LeetCode.Strings;

public class ImplementStrStr {

    public static void main(String[] args) {
        String haystack="abhishek"; String needle="abhi";
        System.out.println(strStr(haystack,needle));
    }

    public static  int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) { // The pointer of haystack
            for (int j = 0; ; j++) { // The pointer of needle
                if (j == needle.length()) return i; // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
                if (i + j == haystack.length()) return -1; // This happens when we run out of elements in haystack, but there are still elements in needle.
                if (needle.charAt(j) != haystack.charAt(i + j)) break; // We stop comparing after needle[j], so i will be incremented and cycle repeats itself.
            }
        }
    }
}
