package SortingAlgo;

import java.util.Arrays;

/*When to use

Mostly for teaching inversions/stability.

Rarely the best practical choice; insertion sort usually beats it.

        Complexity & traits

Time: worst/avg O(n²), best O(n) with early exit

Space: O(1)

Stability: Stable

Swaps: many (costly vs insertion)*/
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {5,3,2,8,9,7,6,1};
        boolean swapped = true;
        for(int end = a.length-1; end > 0 && swapped;end--){
            swapped=false;
            for(int i =0; i < end;i++){
                if(a[i] > a[i+1]){
                    int t = a[i];
                    a[i] =a[i+1];
                    a[i+1]=t;
                    swapped=true;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
