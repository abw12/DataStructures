package JavaConcurrency;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(List.of(3, 5, 1, 2, 7, 8, 9));
        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
        //this 10 will not appear in our iterator
        copyOnWriteArrayList.add(10);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
//            iterator.remove(); //remove is not allowed will throw an UnsupportedOperationException
        }
        System.out.println("========================");
        //will appear in loop
        copyOnWriteArrayList.forEach(System.out::println);
    }
}
