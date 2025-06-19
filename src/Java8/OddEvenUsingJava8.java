package Java8;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class OddEvenUsingJava8 {

    private static Object object=new Object();

   private static IntPredicate evenCond = e -> e%2==0;
   private static  IntPredicate oddCOnd = o -> o%2!=0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()-> OddEvenUsingJava8.printNumber(evenCond));
        CompletableFuture.runAsync(() -> OddEvenUsingJava8.printNumber(oddCOnd));
        Thread.sleep(1000);
    }

    public static  void printNumber(IntPredicate condition){
        IntStream.rangeClosed(1,10).filter(condition).forEach(OddEvenUsingJava8::execute);
    }

    public static void execute(int no){
        synchronized (object){
            try {
                System.out.println(Thread.currentThread().getName() + " : "+ no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
