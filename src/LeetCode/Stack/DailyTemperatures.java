package LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    private static int[] dailyTemp(int[] temperatures){
        int len = temperatures.length;
        int[] answer = new int[len];
        if (len == 1) return answer;

        // Self tried approach naive and doesn't clear all test cases in the leetcode.
        // it fail 47th test case with time limit exceeded exception

        // int l=0,r=1;
        // while(l < len-1){
        //     if(temperatures[r] > temperatures[l]){
        //         answer[l]=r-l;
        //         l++;
        //         r++;
        //      }else{
        //         while(r < len){
        //             if(temperatures[r] > temperatures[l]){
        //                answer[l]=r-l;
        //                 break;
        //             }
        //             r++;
        //         }
        //         l++;
        //         r=l+1;
        //      }
        // }
        // answer[len-1]=0;
        // return answer;

        // Optimal Approach using the Stack DS to store the temp when there are no immediate warmer temp
        // once we find the next warmer temp(day) then pop the stack and fill the temp gap between days
        Stack<Integer> st = new Stack<>();
        for(int i=0; i < len;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                answer[idx]= i - idx;
            }
            st.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemp(temp)));
     }

}
