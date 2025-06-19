package DesignPatterns.Behavioural.Strategy;

//concrete strategy class
public class MergeSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("sorting using merge sort algo.");
    }
}
