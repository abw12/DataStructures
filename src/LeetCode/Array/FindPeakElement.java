package LeetCode.Array;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};

        System.out.println("Index of Peak element: " +findPeakElement(arr));
    }


/*  Case 1 : mid lies on the right of our result peak ( Observation : Our peak element search space is leftside )
    Case 2 : mid is equal to the peak element ( Observation : mid element is greater than its neighbors )
    Case 3 : mid lies on the left. ( Observation : Our peak element search space is rightside )*/

/*    Some base cases :

    The array could be strictly increasing or strictly decreasing and as we have to return any of the possible peaks,
    so we could add a condition to check whether the 1st element/last element could be the peak ).
    This point is also supported by the fact that, we are looking for mid-1/ mid+1
    ( and these indices are compremised for 0th index / n-1 th index respectively.*/
    private static int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        //check for the 0th /nth-1 index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n -1] > nums[n -2]) return n-1;

        //search in the remaining array
        int start =1 ;
        int end = n-2;
        while(start <= end ){
            int mid = start + (end - start )/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){ //mid itself is the peak element
                return mid;
            }else if(nums[mid] < nums[mid+1]){ //the peak element will be on the right side space
                start = mid +1;
            }else {  //so our peak element is on the left side space
                end = mid -1;
            }
        }
        return -1;
    }
}
