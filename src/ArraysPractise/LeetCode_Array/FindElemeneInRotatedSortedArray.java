package ArraysPractise.LeetCode_Array;

class BinarySearch{
    //0,1,2,4,5,6,7
    public  int search(int[] nums,int target){
        if(nums == null && nums.length == 0) return -1;

        int left =0;
        int right =nums.length-1;
        while (left <= right){
            int midpoint= left + (right -left) /2;
            if(nums[midpoint] == target){
                return midpoint;
            }else if( nums[midpoint] < target){
                left=midpoint+1;
            }else{
                right=midpoint-1;
            }
        }
        return -1;
    }


    //[2,3,5,9] target = 1 or 13 or 6
    public int searchInsert(int[] nums , int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left= mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}


public class FindElemeneInRotatedSortedArray {


    public static int findNumber (int[] nums , int target){
        if(nums==null && nums.length ==0) return -1;
        //4,5,6,7,0,1,2
        int left =0;
        int right=nums.length-1;
        while(left < right){
            int midpoint = left + (right-left)/2; //to avoid number going overflow then last index and find midpoint
            if(nums[midpoint] > nums[right] ){ //this is the modified binary search to check how many numbers the array have been rotated and find the lowest element position
                left=midpoint+1;
            }else {
                right = midpoint;
            }
        }

        int start = left;
        left=0;
        right=nums.length-1; //reinitialize left and right value

        if(target >= nums[start] && target <= nums[right] ){
            left=start;
        }else{
            right=start;
        }

        //now doing normal binary search
        while (left <= right){
            int midpoint = left + (right - left)/2;
            if(nums[midpoint]==target){
                return midpoint;
            }else if(nums[midpoint] < target){
                left=midpoint+1;
            }else{
                right=midpoint-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums ={4,5,6,7,0,1,2};
        int target=20;
        System.out.println("Element is in rotated array at index : "+findNumber(nums,target));

        //normal way of searching an element using binary search algo which  works for only sorted array & efficient in non-duplicate elements
        int[] numsBS ={20,11,13,14,15,19,10}; //this array must a  sorted array for Binary Search to work
        BinarySearch bs = new BinarySearch();
        System.out.println("Binary Search : " + bs.search(numsBS,target));

        //Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
        //You must write an algorithm with O(log n) runtime complexity.
        System.out.println("Search Inserted Index : " + bs.searchInsert(nums,target));
    }
}
