package LeetCode.Stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public static int longestValidParentheses(String s) {
        Stack<Integer> st =new Stack<>();
        Integer maxlen= 0;
        st.push(-1); // dummy element for start so if the first character is ) then we can remove this element and continue our logic since we don't want to keep the stack empty

        for(int i=0;i< s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i); //push the index of current character into stack
            }else{
                st.pop(); //if its a ) bracket then simply pop the last element
                if(st.isEmpty()){
                    st.push(i); //since we don't want to keep the stack empty if it becomes empty at any point we have push current index position of the loop
                }else{
                    maxlen=Math.max(maxlen,i-st.peek()); // to find the valid maxlen substring of parenthesis use formula current index - element at top of stack(peek)
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String input ="(()";
        System.out.println(LongestValidParenthesis.longestValidParentheses(input));
    }
}
