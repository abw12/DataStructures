package LeetCode.Array;

public class JumpGame {

    public static void main(String[] args) {

        //Jump Game 1
        int[] game1 = {2,1,1,1,4};
        System.out.println(jumpGame1(game1));

        System.out.println(jumpGame2(game1));
    }

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
