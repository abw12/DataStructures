package LeetCode.Array;


/*Given an integer array nums, return true if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.*/
public class IncreasingTriplets {

    public static boolean increasingTriplet(int[] nums){
        //Greedy approach
        int smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;
        for(int n : nums){  // use int data type other than Integer class since using data type improve time in leetcode.
            if( n <= smallest){
                smallest = n;
            }else if(n <= second_smallest){
                second_smallest = n;
            }else{
                return true; //if any number enter else that mean we have found the triplets
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,0,4,6};

    }
}
