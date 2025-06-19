package ArraysPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSortAlgo {

    public static void main(String[] args) {

        //numbers in the list should be between 0-9 only for simplicity
       List<Integer> inputList = Arrays.asList(2,3,1,2,3,4,9,1,5,8,7);

        System.out.println(countingSort(inputList).toString());

    }

    private static List<Integer> countingSort(List<Integer> inputList) {
        //for simplicity i'm assuming the range of 0-9 (i.e the value of k )
        int[] count = new int[10];
        List<Integer> result = new ArrayList<>();
        if(inputList.size()<=100){
            for(Integer integer : inputList ){
                if(integer < 10){
                    count[integer]+=1;
                }
            }
            for(int j = 0 ; j < count.length; j++){
                while(count[j] > 0) {
                    result.add(j);
                    count[j]--;
                }
            }
        }
        return result;

    }
}
