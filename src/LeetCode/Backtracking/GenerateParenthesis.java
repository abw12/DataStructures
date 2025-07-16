package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res,"",0,0,n);
        return res;
    }

    private static void backTrack(List<String> res , String str , int open , int close,int max){
        //base condition
        if(str.length() == max * 2){
            res.add(str);
            return;
        }

        //keep on adding the open '(' parenthtesis until its less than the N(ie max)
        if(open < max){
            backTrack(res,str+"(",open+1,close,max);
        }
        //we only add the closing parenthesis ")" when its less than the opening parenthesis "("
        //coz that will only give us the valid combinations of the parenthesis string formed
        if(close < open){
            backTrack(res,str+")",open,close+1,max);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
