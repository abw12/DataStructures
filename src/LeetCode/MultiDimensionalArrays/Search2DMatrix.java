package LeetCode.MultiDimensionalArrays;


/*You are given an m x n integer  matrix with the following two properties:

        Each row is sorted in non-decreasing order.
        The first integer of each row is greater than the last integer of the previous row.
        Given an integer target, return true if target is in matrix or false otherwise.

        You must write a solution in O(log(m * n)) time complexity.*/
public class Search2DMatrix {
    public boolean searchMatrix(int[][]matrix ,int target){
        if(matrix == null || matrix .length == 0 ){
            return false;
        }

        int start =0,rows=matrix.length , cols = matrix[0].length;
        int end = rows * cols - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            //calculate the index position of the row and col using the mid point with respect to the cols size
            if(matrix[mid / cols][mid % cols] == target){
                return true;
            }
            else if(matrix[mid / cols][mid%cols] < target){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return false;
    }


    public static int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target){
            return 0;
        }

        int left =0 ; int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[right] < nums[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        int start = left ;
        left = 0; right = nums.length -1;
        if(nums[start] == target)
            return start;

        if(nums[start] <= target && nums[right] >= target){
            left =start;
        } else{
            right =start;
        }

        while(left <= right){
            int mid = left +( right - left )/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
}
