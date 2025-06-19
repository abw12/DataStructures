package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFI  /*implements Consumer<Integer>*/ {


    //we can also implement this class with consumer functional interface just the way we implement any normal interface
    // and implement its abstract methods
    //though we don;t so such implementation on functional interfaces on the class since we oppse the use of lambda expression
    //which is the sole purpose of using the functional interfaces
    public static void main(String[] args) {
        int num = 10;

        Consumer<Integer> consumer = (n)->{
            System.out.println(n);
        };

        consumer.accept(20);

        List<Integer> list = Arrays.asList(1,4,6,7,9);
        //using the same consumer object which was initialized to print all the numbers in the given list one by one
        list.forEach(consumer);

        //also can directly pass the consumer functional interface as lambda expression in the forEach method
        list.forEach( n -> System.out.println("prints: " + n));
    }
}
