package DesignPatterns.Behavioural.Strategy;
//concrete strategy class
public class QuickSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] array) {
        System.out.println("sorting using quick sort algo.");
    }
}
