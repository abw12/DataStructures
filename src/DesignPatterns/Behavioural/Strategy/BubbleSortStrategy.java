package DesignPatterns.Behavioural.Strategy;


//concrete strategy class
public class BubbleSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("sorting using bubble sort algo.");
    }
}
