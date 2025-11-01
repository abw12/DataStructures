package LeetCode.Array;

public class RemoveElement {

    //remove the target element and return the length of the array after removal is done
    public static int removeElement(int[] nums , int val){
        //gives O(n) time complexity but little slower
        //     int j=0;
        //     for(int i=0; i < nums.length ; i++){
        //         if(nums[i] != val){
        //             nums[j]=nums[i];
        //             j++;
        //         }
        //     }
        //     return j;

        //give O(n) time complexity but much faster than above solution
        int len = nums.length;
        for (int i=0; i<len; i++) {
            if (nums[i] == val) {
                nums[i--] = nums[--len];
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] input = {0,1,2,2,3,0,4,2};
        int target = 2;
        System.out.println("Answer :" +  removeElement(input,target));

    }
}
