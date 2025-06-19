package DesignPatterns.Behavioural.IteratorDesignPattern;

import java.util.*;

public class ListIterators {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for(int i =1 ; i <= 100 ; i++){
            list.add(i);
        }

        System.out.println("List: " + list.toString());

        //list iterator is specifically for the list implementation classes as it provide some additional methods like previous n all
        ListIterator<Integer> integerListIterator = list.listIterator();
        if(integerListIterator.hasPrevious())
            System.out.println(integerListIterator.previous());

        //iterators is generic for all collections therefore it does not provide any additional method for list implementation
        Iterator<Integer> iterator = list.iterator();
        System.out.println( iterator.next() );

        //provide some method to add/remove element from list while traversing over it
        integerListIterator.add(101);

        System.out.println("After listiterator add method: " + list.toString());
    }
}
