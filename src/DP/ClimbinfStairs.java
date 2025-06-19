package DP;

import java.util.HashMap;
import java.util.Map;


//in how many ways we can climb stairs with 1step & 2 step at a time ?
//eg to climb 4 steps we have below different ways
//        1 + 1 + 1 + 1
//        1 + 2 + 1
//        1 + 1 + 2
//        2 + 1 + 1
//        2 + 2
public class ClimbinfStairs {


    //brute force approach
    //to reach the nth stair one can jump either (N-1)th or from (N-2)th stair.
    //hence,for each step,total ways would be the summation of (N-1)th stair + (N-2)th

    public int bruteForceClimbStair(int steps){
        if(steps < 2 ) return  1;  //base condition

        return bruteForceClimbStair(steps-1) + bruteForceClimbStair(steps-2); //this is nothing but the fibonacci series calc
    }

    //this technique of using dynamic programming (memoization) gives us O(n) time complexity
    //this problem is similar to the fibonacci series problem
    //maintaining the map to keep the result of fibonacci of the previous values so that we don't have to calculate it recursively
    private Map<Integer,Integer> memo =new HashMap<>();
    public Integer climbStairs(int n){
        return helper(n);

    }

    public Integer helper(int n){
        int result;

        //below three are base condition
        if(memo.containsKey(n)) return memo.get(n);

        //here the n input is the no. of steps and not the index position .hence the base condition differes from the fibonacci series question
        //rest all the code and logic is same
        if(n == 1) return 1;
        if(n == 2) return 2;
//        if(n < 2) return n;

        result=(helper(n-2) + helper( n-1));
        memo.put(n,result);
        return result;
    }

    //Fibonacci Number iterative approach
    public int FibonnacinumberApproach(int steps){
        if(steps == 1 ) return 1;
        if(steps == 2 ) return 2;

        int first =1;
        int second =2;
        int result = 0;

        for(int i = 3 ; i <= steps ; i++){
            int third=first+second;
            first=second;
            second=third;
            result=third;
        }
        return result;
    }
//    0 1 1 2 3 5 8

    public static void main(String[] args) {
        ClimbinfStairs cms= new ClimbinfStairs();
        int n=5;
        System.out.println("Memoization: "+ cms.climbStairs(n));
        System.out.println("Brute Force: "+ cms.bruteForceClimbStair(n));
        System.out.println("Fibonacci Approach: " + cms.FibonnacinumberApproach(n));
    }
}
