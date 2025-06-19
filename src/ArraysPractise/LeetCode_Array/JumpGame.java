package ArraysPractise.LeetCode_Array;

public class JumpGame {

    public static void main(String[] args) {

        //Jump Game 1
        int[] game1 = {2,1,1,1,4};
        System.out.println(jumpGame1(game1));

        System.out.println(jumpGame2(game1));
    }

    private static boolean jumpGame1(int[] game1){
        int l = game1.length;
        int goal = l-1;
        for(int i = l-2; i >=0 ; i--){
            if(i + game1[i] >= goal){
                goal--;
            }
        }
        return goal == 0;
    }

    // {2,1,1,1,4}
    private static int jumpGame2(int[] game2){
        int l = game2.length;
        int min_jumps=0;
        int near=0,far=0; //near is min jump and far is max jump that can be taken form a particular index
        while(far < l-1){
            int farthest=0; //farthest i can got from current index
            for(int i=near; i < far+1; i++){
                farthest=Math.max(farthest,i + game2[i]);
            }
            near=far+1;
            far=farthest;
            min_jumps++;
        }
        return min_jumps;
    }
}
