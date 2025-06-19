package BasicPrograms;

public class StringPalindrome {

    public static void main(String[] args) {
        String input = "nitin";
        input = input.toLowerCase();

        String s="A man, a plan, a canal: Panama";
        System.out.println("is Palindrome: " +isPalindrome(input));
        System.out.println("leetcode palindrome: " + validPalindrome(s));
        System.out.println("leetcode palindrome better approach: " + betterSolution(s));
    }

//    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
//    it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//    Given a string s, return true if it is a palindrome, or false otherwise

    //this solution is taking alot of run-time 1076ms in leetcode
    private static boolean validPalindrome(String s){
        String modifiedS = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");

        String reverse = "";
        for(int i = modifiedS.length() -1 ; i >=0 ; i-- ){
            reverse+=modifiedS.charAt(i);
        }
        return modifiedS.equals(reverse);
    }

    //this tow pointer algo approach is much faster compared to the regex approach above
    //it takes only 3ms runtime in leetcode
    //time complexity is O(n) space : O(1)
    private static boolean betterSolution(String s){
        if(s.isEmpty()) return true;

        int start =0 ;
        int end = s.length()-1;

        while(start <= end){
            char currFirst = s.charAt(start);
            char currLast  = s.charAt(end);
            if(!Character.isLetterOrDigit(currFirst)){ //if its not a letter or a digit just move ahead the start pointer
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                end--;
            }else {
                if(Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String input){
        String reverse = "";
        String[] arr = input.split("");
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += input.charAt(i);
        }
//        if (input.equals(reverse)) {
//            System.out.println("not a palindrome");
//        } else {
//            System.out.println("is palindrome");
//        }

        return input.equals(reverse);
    }
}
