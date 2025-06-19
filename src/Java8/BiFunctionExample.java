package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {
        //The BiFunction interface allows us to use parameters of different types, with a return value of a third type.
        List<Integer> list1 = Arrays.asList(10,20,30);
        List<String> list2 = Arrays.asList("a","b","c");

//        List<String> result = new ArrayList<>();
//        for(int i=0;i<list1.size();i++){
//            result.add(list1.get(i) + list2.get(i));
//        }
        //calling the below generalize method listCombiner
        //here we passing two list with diff data type and return type is string
        List<String> result =listCombiner(list1,list2,(num,letter) -> num + letter);
        System.out.println(result);

        //we can also pass the two diff data type as param and the return is also diff from both of them
        List<Double> list3 = Arrays.asList(10.6,20.9,30.10);
        List<Float> list4 = Arrays.asList(20.9f,30f,27f); //when we mention f it specifically take float else it will consider decimal value as double

        //return type is another  diff data type
        List<Boolean> result2 = listCombiner(list3,list4,(doubleNumber,floadtNumber) -> doubleNumber > floadtNumber);
        System.out.println(result2);

    }
    //generalize the above algorithm to combine two list into elements into third
    private static <T,U,R> List<R> listCombiner(List<T> list1, List<U> list2 , BiFunction<T,U,R> combiner){
        List<R> result =new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            result.add(combiner.apply(list1.get(i),list2.get(i)));
        }
        return result;
    }
}
