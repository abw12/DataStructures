package LeetCode.Two_Pointer;

public class RemoveDuplicateFromArray2 {

    public static int removeDuplicates(int[] nums) {
        int k=2;
        for(int i=2;i<nums.length;i++){
            // if we find the unique element
            if(nums[i] != nums[k-2]){
                //swap ith position element with kth positon element, since we can't have 3 consecutive same elements
                int temp = nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k++;
            }
        }
        return k; //return s the length of the array of allowing only one duplicate element
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
