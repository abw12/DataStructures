package ArraysPractise;

public class FindSecondHighestElementWithOutSorting {


    public static void main(String[] args) {

        int[] input = {2,5,1,7,8,19,11};

        findSecondHighestElement(input);
    }

    private static void findSecondHighestElement(int[] input) {
                int highest = Integer.MIN_VALUE;
                int secondHighest=0;int index;

                for(index=0; index < input.length ; index++){
                    if(highest < input[index]) {
                        secondHighest = highest; //will always store the previous highest value which will eventually be the second highest
                        highest = input[index];
                    }
                    if(secondHighest < input[index] && highest > input[index] ){
                        secondHighest = input[index];
                    }
                }
                System.out.println("Seconda Highest Element in Array is: "+ secondHighest);
    }
}
