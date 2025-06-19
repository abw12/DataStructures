package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class RestorIPAddress {
    static List<String> result = new LinkedList<>();
    public static void main(String[] args) {
        String input =/*"25525511135"*/ "1111";
        System.out.println(restoreIP(input));
    }

    private static List<String> restoreIP(String inputString){
        if(inputString.length() == 0) return result;
        dfs(new StringBuilder(),inputString,4);
        return result;
    }

    private static  void dfs(StringBuilder str , String s , int sections){
        //base conditions
        int n = s.length();
        if(n == 0 && sections == 0){
            result.add(str.substring(0,str.length()-1));
        }
        if(n > 0 && sections == 0) return;
        if(n == 0 && sections > 0) return;

        StringBuilder sb = new StringBuilder(); //this will store the current string for the section
        int min = Math.min(s.length(),3); //this is for corner case where we are left with only 2 or 1 character at the end of string (1.3.44.55)
        //for loop is for forming a string for each section which will be of length 3 at max
        for(int i =0 ; i < min ; i++){

            sb.append(s.charAt(i));
            int val = Integer.parseInt(sb.toString()); //max string will have 3 character ex: 255
            //validate the value
            if(sb.length() == 2 && val < 10) continue; //meaning 2 character are there and there value is less than the 10
            if(sb.length() == 3 && val < 100) continue; //meaning 3 character are there and there value is less than the 100
            if(sb.length() == 3 && val > 255) continue;

            //try all combination for the current String after putting the dot
            StringBuilder temp = new StringBuilder(str.toString()); //this used to keep track of current string when we return (backtrack)
            // the path while coming back from recursion
            str.append(sb.toString()); //adding the current formed string in one section
            str.append(".");
            dfs(str,s.substring(i+1,s.length()),sections-1);
            //reset our current string for next dfs
            //this is if we follow a path and that is invalid then while coming back above one recursion level we want to start
            // from the initial string again in that particular recursion level
            str=temp;
        }
    }
}
