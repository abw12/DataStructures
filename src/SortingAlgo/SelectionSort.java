package SortingAlgo;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {5,3,2,8,9,7,6,1};

        for(int i=0; i < a.length-1;i++){
            int min=i;
            for(int j=i+1; j < a.length;j++){
                if(a[j] < a[min]){
                    min=j;
                }
                if(min != i){
                    int t = a[i];
                    a[i]=a[min];
                    a[min]=t;
                }
            }
        }
        System.out.println(Arrays.toString(a));


    }
}
