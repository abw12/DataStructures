package DP;

import java.util.HashMap;
import java.util.Map;
//index         0 1 2 3 4 5 6 7
//fibbo values: 0 1 1 2 3 5 8 13
public class FibonacciSeries {
    //recursive approach with memoization

    static Map<Integer,Integer> memo = new HashMap<>();
    public  Integer fibbo(int n){

        if(memo.containsKey(n)) return memo.get(n);

        //base condition
        if( n < 2) return n;

        int result =0;
        result=(fibbo(n-2) + fibbo(n-1));
        memo.put(n,result);
        return result;
    }

//    public Integer fibboNormal(int n){
//
//        //base condition
//        if(n < 2) return n;
//
//        return fibboNormal(n-2) + fibboNormal(n-1);
//    }

    public static void main(String[] args) {
    FibonacciSeries fs = new FibonacciSeries();

        System.out.println(fs.fibbo(7)); //passing here the index (means the position at which what should be the fibbo value )
        memo.entrySet().forEach(System.out::println);

        System.out.println("====================================");
//        System.out.println(fs.fibboNormal(35));
    }
}
