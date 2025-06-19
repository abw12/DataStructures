package LeetCode_String;

import java.util.Stack;

///Hard level problem ,solution below is not correct fails most of the corner case (156 TC passed out of 231 in leetcode)

//given question is  to find longest substring of valid parenthesis
//eg: String s="()()))" here no. of opening and closing parenthesis should be same in continues sequence
//    o/p: 4 for above
public class LongestSubstringParentheses {
    public static void main(String[] args) {
        String input="()(())((())";
//        String input = "()()))";
        Stack<Character>  parenthesis = new Stack<>();
        int maxCount=0;
        int count=0;
        for(char c : input.toCharArray()){
            if(c == '('){
                parenthesis.push(')');
            }else{
                if(!parenthesis.isEmpty()){
                    parenthesis.pop();   //count the no. of pop we are doing
                    count++;
                }else{
                    count=0;  //if stack becomes empty reset the count=0 as the substring is ended
                }
                if(count > maxCount) maxCount=count;
            }
        }
        System.out.println("Longest Substring of valid parenthesis is: "+ maxCount*2);


    }
}
