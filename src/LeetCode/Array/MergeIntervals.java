package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    // basic logic is : If current starting time is less than ending time in previous interval, they are overlapping.
    //but problem here is there is some distance between [1,3] and [2,6] because we have [15,18] and [8,10].
    //That's why it's good idea to sort all intervals with starting time before iteration. After sorting, we will have
//    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    private static int[][] mergeIntervals(int[][] intervals){
        if(intervals.length == 1) return intervals;

        //sort the array subarrays with starting point
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0])); above comparator is shot hand to this

        List<int[]> merged = new ArrayList<>(); //create a list of integer array to sort the merged intervals
        int[] prev = intervals[0]; //start with the 0th index subarray as the previous value to compare with adjacent values
        for(int i=1; i < intervals.length; i++){
            int[] current_interval = intervals[i];
            if(current_interval[0] <= prev[1]){
                prev[1] = Math.max(prev[1],current_interval[1]);
            }else{
                merged.add(prev);
                prev=current_interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
      int[][] intervals = {{1,3},{15,18},{8,10},{2,6}};
      int[][] ints = mergeIntervals(intervals);
      System.out.print("Merging overlapping intervals :: ");
      for (int[] interval : ints) {
          System.out.print(Arrays.toString(interval) + " ");
      }
      System.out.println();
    }
}
