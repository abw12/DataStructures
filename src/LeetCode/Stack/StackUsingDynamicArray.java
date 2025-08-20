package LeetCode.Stack;

import java.util.Arrays;
import java.util.Iterator;

public class StackUsingDynamicArray implements  Iterable<String> {

    private String[] s;

    private int size = 0;

    public StackUsingDynamicArray(){
        s= new String[1];
    }

    private void push(String value){
        if(size == s.length) resize(2 * s.length);
        s[size++] = value;
    }

    public void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i=0; i < size ; i++){
            copy[i]=s[i];
        }
        s=copy; //changing the size of s array with its original values
    }

    public String pop(){
        //this version is avoiding loitering (avoid Holding reference to an object when it is no longer needed)
        String item = s[--size]; //since size is staring from 1 for first push operation here using prefix operator to reduce it by one first then return the value
         s[size] = null;
         if(size > 0 && size == s.length/4) resize(s.length/2);  //halving the size of dynamic array if array is only 25% (quarter) full to avoid having big empty array
         return item;
    }

    public void print(){
        System.out.println(Arrays.asList(s));
    }

    public static void main(String[] args) {
        StackUsingDynamicArray stack = new StackUsingDynamicArray();
        stack.push("abhishek");
        stack.push("suresh");
        stack.push("wasave");
        stack.push("dumb");
        stack.pop();
        stack.print();


        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
        }

        //I'm able to use forEach on StackUsingDynamicArray object since we have implemented Iterator on the class
        for(String value : stack.s){
            System.out.println("F: " + value);
        }

    }

// Note that our stack iterator returns the items in LIFO order, whereas \verb#java.util.LeetCode.Stack#java.util.LeetCode.Stack returns them in FIFO order.
    @Override
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements  Iterator<String>{


        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public String next() {
            return s[--size];  //removing element from the end of the array as it's a stack for Iteration
        }
    }
}
