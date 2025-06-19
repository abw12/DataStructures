package DesignPatterns.Behavioural.Strategy;

public class SortingContext {

    private SortingStrategy sortingStrategy; //Ref to the sortingstrategy, this ref allows us to interchangeably  select different sorting algorithm

    public SortingContext(SortingStrategy sortingStrategy){
        this.sortingStrategy=sortingStrategy;
    }
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array){
        sortingStrategy.sort(array);  //context class delgates the task to the concrete strategy class as per the strategy selected by client
    }

}
