package ArraysPractise.LeetCode_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*Given two integer arrays nums1 and nums2, return an array of their intersection.
        Each element in the result must be unique and you may return the result in any order.*/
public class ArrayIntersection1 {
    //can be solved similar to the Array Intersection 2 problem only difference is that result contain unique element
//  Another  can be solution using HashSet give same O(n) time
    public static int[] intersect (int[] nums1,int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1= {1,2,2,1};
        int[] nums2 ={2,2,};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

        Set<Integer> result = new HashSet<>();

        for(Integer n : nums1){
            result.add(n);
        }
        for (Integer n :nums2){
            if(result.contains(n)){

            }
        }
    }
}
