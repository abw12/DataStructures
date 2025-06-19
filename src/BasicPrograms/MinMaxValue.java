package BasicPrograms;

import java.util.Arrays;
import java.util.List;


/*Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
        Then print the respective minimum and maximum values as a single line of two space-separated long integers.*/
public class MinMaxValue {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12,10,5,6,7);
        long min =Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        long fSum=0;

//        Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function.
//                This is a functional interface whose functional method is apply(Object, Object) .
        //reduce method uses the Special BiFunction interface called BinaryOperator which accept two parameter of same type and return the same type
        long sum = arr.stream().reduce(0,Integer::sum).longValue();
        for(int j = 0 ; j < arr.size();j++){
            fSum=sum-arr.get(j);
            min=Math.min(min,fSum);
            max=Math.max(max,fSum);
        }
        System.out.println(min +" " +max);
    }
}
