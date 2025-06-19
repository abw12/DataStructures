package LeetCode_String;

import java.util.Stack;

public class Max_Depthof_Parenthesis {
    public static void main(String[] args) {
        String s ="(1)+((2))+(((3)))";
        System.out.println("Max Depth of Parenthesis is: "+ maxDepth(s));
    }

    private static int maxDepth(String s) {

        Stack<Character> stack = new Stack<>();
        int maxDepth=0;
        for(int i=0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
                maxDepth=Math.max(maxDepth,stack.size());
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return maxDepth;

    }
}
