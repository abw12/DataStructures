package ArraysPractise.LeetCode_Array;

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
                return true; //if any number enter else that mean
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,0,4,6};

    }
}
