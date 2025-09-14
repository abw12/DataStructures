package LeetCode.Array;

public class JumpGame {

    public static void main(String[] args) {

        //Jump Game 1
        int[] game1 = {2,1,1,1,4};
        System.out.println(jumpGame1(game1));

        System.out.println(jumpGame2(game1));
    }

    /*You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array
    represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.


            Example 1:

    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
            Example 2:

    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
    */
    //Same time complexity but perform a bit slower in worst case scenario.( runtime taken 2ms compare to 1ms in 1st approach)
    //solve iterating in forward direction
    private static boolean jumpGame1AnotherApproach(int[] nums){
         int far = 0; //right pointer
         int goal = nums.length-1; //last index
         for(int i=0; i < nums.length; i++){ // i is the left pointer
             if(i > far) return false; //gap we can't cross (  when left pointer has crossed the right pointer
             far = Math.max(far,i+nums[i]);
             if(far >= goal){ //if right most pointer reach the last index return true
                 return true;
             }
         }
         return true; // array length 1 or we never hit a gap
    }
    //backward direction approach
    private static boolean jumpGame1(int[] nums){
        int l = nums.length;
        int goal = l-1;
        for(int i = l-2; i >=0 ; i--){
            if(i + nums[i] >= goal){
                goal=i;
            }
        }
        return goal == 0;
    }

    //Jump game question 2
    /*You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

    Each element nums[i] represents the maximum length of a forward jump from index i.
    In other words, if you are at index i, you can jump to any index (i + j) where:

            0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

    Example 1:

    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
            Example 2:

    Input: nums = [2,3,0,1,4]
    Output: 2*/

    // {2,3,1,1,4}
    private static int jumpGame2(int[] nums){
        int len = nums.length;
        int near=0;int far=0;int min_jumps=0;
        //nums = [2,3,1,1,4]
        while (far < len-1){ //break after 2 loops
            int farthest =0;
            for(int i=near;i < far+1 ; i++){ //far+1 since we have to make rightmost value inclusive
                farthest=Math.max(farthest, i + nums[i]); //current index + jumps at current_index(nums[i])
            }
            near=far+1; //1;3 -> after each iteration values
            far=farthest; //2;4
            min_jumps++; //1;2
        }
        return min_jumps; //2
    }
}
