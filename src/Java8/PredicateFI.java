package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFI /*implements Predicate<Integer>*/ {
//    @Override
//    public boolean test(Integer integer) {
//        return false;
//    }
public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,4,6,7,9);

    Predicate<Integer> predicate = new Predicate<Integer>() {

        @Override
        public boolean test(Integer integer) {
            if(integer % 2 == 0){
                return true;
            }else{
                return false;
            }
        }
    };

    System.out.println(predicate.test(10));

    //forEach is using th consumer accept() method and inside that method again we are calling the predicate test(0 method
    //here the lambda expression is used for the foreach method and not the predicate method
//    list.forEach(n -> System.out.println(predicate.test(n)));

    //directly using the lambda expression for the predicate
    //now here first we are using the test method in lambda expression  form for the predicate functional interface
    //since predicate return a value for each item , so output of filter will be a list of values that where calculated by predicate as true
    //rest all false value will be filtered out
    //and the forEach will print all boolean values using the consumer accept method via lambda expression
    list.stream().filter(n -> n%2==0).forEach(System.out::println);

}

}
