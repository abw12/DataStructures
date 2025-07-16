package LeetCode.MultiDimensionalArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxIntersectionLines {

    public static void main(String[] args) {
        int[][] lines = {{1,2},{1,3},{2,3},{4,4}};
        int N=4;
        System.out.println(maxIntersections(lines,N));
        System.out.println(betterApproach(lines,N));
    }

    //naive approach will timeout exceeds for the very large inputs
    //time complexity is O(n * max);
    public static int maxIntersections(int[][] lines, int N) {
        // Code here
        int max =Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i < N ; i++){
            for(int j=lines[i][0] ; j <= lines[i][1];j++){
                map.put(j,map.getOrDefault(j,0)+1);
            }
        }
        for(Integer value: map.values()){
            max=Math.max(max,value);
        }
        return max;
    }

    private static int betterApproach(int[][] lines,int N){
        // sorting and two pointer approach

        //we are taking starting point and ending point of each line segment seperately and then sorting it
        int[] startingPoints = new int[N];
        int[] endingPoints = new int[N];

        //fill the both arrays
        for(int i=0 ; i < N ; i++){
            startingPoints[i]=lines[i][0];
            endingPoints[i]=lines[i][1];
        }

        //sort the both arrays
        Arrays.sort(startingPoints) ; Arrays.sort(endingPoints);

        //now do the comparision as by using two pointers
        int i=0, j=0,intersection=0,max=Integer.MIN_VALUE;
        while(i<N && j<N){
            if(startingPoints[i] <= endingPoints[j]){
                //new line starting before a line ending
                intersection++;
                max=Math.max(max,intersection);
                i++;
            }else {
                //line ending before new line starts
                intersection--;
                j++;
            }
        }
        return max;
    }
}
