package BasicPrograms;

import java.util.ArrayList;
import java.util.List;
import  java.util.Arrays;

public class Fibonacci {
    public static void fibonacci(int num){
        long start = System.currentTimeMillis();
        List<Integer> fiboNumList= new ArrayList<>(Arrays.asList(0,1));
        for(int i=2 ; i <= num ; i++){
             fiboNumList.add(fiboNumList.get(i-2) + fiboNumList.get(i-1));
        }
        long end = System.currentTimeMillis();
        System.out.println(fiboNumList + " Time Taken = " + (end-start));

    }

    //recursive approach its very slow for large number like 100 so not a feasible solution
    //if used with memoization(dynamic programming) then it's much faster
    //it takes O(2^n) time complexity
    public static int recursiveAprroach(int n){

//        if(n == 0) return 0;
        if( n < 2) return n;

        return recursiveAprroach(n-2) + recursiveAprroach(n-1);
    }
    public static void main(String[] args) {
        //0 1 1 2 3 5 8 13 21
        int num=50;

        long start = System.currentTimeMillis();
        fibonacci(num);
        long end = System.currentTimeMillis();
        System.out.println("Iterative time taken : "+ (end - start));

        long start2 = System.currentTimeMillis();
        System.out.println("Fibonacci Number: " +recursiveAprroach(num));
        long end2 = System.currentTimeMillis();
        System.out.println("Recrusive function time taken : "+ (end2 - start2));
    }
}
