package LeetCode.Stack;

import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
public class ValidParenthesis {

    public boolean isValid(String s) {

        String[] arr = s.split("");

        int round_open=0,round_close=0;
        int square_open=0,square_close=0;
        int curly_open=0,curly_close=0;

        for(int i=0; i < arr.length;i++ ){
            if(arr[i].equals("(") ){
                round_open++;
            }else if(arr[i].equals(")")){
                round_close++;
            }else if(arr[i].equals("[")){
                square_open++;
            }else if(arr[i].equals("]")){
                square_close++;
            }else if(arr[i].equals("{")){
                curly_open++;
            }else if(arr[i].equals("}")){
                curly_close++;
            }

        }
        if( round_open == round_close && square_open == square_close && curly_open ==  curly_close ){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkParenthesis(String input){
        
        Stack<Character> parenthesis = new Stack<>();
       for(char c : input.toCharArray()){
           if(c == '('){
               parenthesis.push(')');
           } else if (c == '[') {
               parenthesis.push(']');
           } else if (c == '{') {
               parenthesis.push('}');
           } else if ( parenthesis.isEmpty() || parenthesis.pop()!= c) {
               return false;
           }
       }
       return  parenthesis.isEmpty();
    }

    public static void main(String[] args) {

        String input ="({()}[]())";
        ValidParenthesis obj = new ValidParenthesis();

        System.out.println("Valid Parenthesis: "+obj.isValid(input)); //this is wrong fail many test cases
        System.out.println("Valid Parenthesis: "+obj.checkParenthesis(input));
    }
}
