package LeetCode.Array;

import java.util.*;

/*Given two integer arrays nums1 and nums2, return an array of their intersection.
        Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.*/

/*
Follow up:

        What if the given array is already sorted? How would you optimize your algorithm?
        What if nums1's size is small compared to nums2's size? Which algorithm is better?
        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

public class ArrayIntersection2 {

    public static void main(String[] args) {

        int[] nums1={4,9,5}; int [] nums2 ={9,4,9,8,4};
//        int[] nums1={1,2,2,1}; int [] nums2 ={2,2};


        //normal way to solve this question
//        System.out.println(Arrays.toString(solution(nums1,nums2)));

        //Follow-up question 1
//       What if the given array is already sorted? How would you optimize your algorithm?
        //this algorthm gives O(max(n,m)) time in worst case scenario,where n=nums1.length and m=nums2.length
        //for example, would be nums1 = {100}, and nums2 = {1, 2, ..., 100 }. We will always iterate the longest array.
//        System.out.println("Result if Arrays are sorted: " + Arrays.toString( sortedArraySolution(nums1,nums2)));
    }

//    This solution is O(N + M) time complexity, O(N) for iterate one of the array to create a hashmap and O(M) to iterate the other array.
//    O(N) space to store such hashmap.
    private static int[] solution(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        //to dynamically decide which array is smaller amoung both I created these method to pass the smaller array to create map
       /* When we create map we should create for array with smaller size to achieve following advantages

        Map.HashMap size will be smaller.
        Less insertion to the Map.HashMap hence it is faster.
        As map is small it avoids map collisions.*/
        int len1=nums1.length;
        int len2=nums2.length;
//        map=nums1.length <= nums2.length ? countFreq(nums1,map) : countFreq(nums2,map);
//
        ArrayList<Integer> list = new ArrayList<>();
//        list= nums1.length > nums2.length ? intersection(nums1,map,list) : intersection(nums2,map,list);

        if(len1 <= len2){
            countFreq(nums1,map);
            intersection(nums2,map,list);
        }else{
            countFreq(nums2,map);
            intersection(nums1,map,list);
        }

        //since the leetcode question is expecting the return type as int[] array we need to convert the list to int[] array
        int[] result = new int[list.size()];
        for(int i =0 ; i < list.size() ; i++){
            result[i]= list.get(i);
        }
        return result;
    }

    //this method count the frequency of first array
    private static Map<Integer,Integer> countFreq(int[] nums, Map<Integer, Integer> map) {
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return map;
    }

    //checking the intersection with 2nd array
    private static ArrayList<Integer> intersection(int[] nums, Map<Integer,Integer> map , ArrayList<Integer> list){
        //looping over the 2nd array to check if the elements of the 2nd array are present in the map of 1st array or not
        //if yes if add that element in our result list and deduct the freq by -1
        for(int i: nums){
            if(map.containsKey(i) && map.get(i) > 0){ ///check if the element has occurred more than once in the map(its frequency)
                list.add(i);
                map.put(i,map.get(i)-1); //deduct the freq of the element by 1
            }
        }
        return list;
    }


    ///Follow-up question 1 solution
    private static int[] sortedArraySolution(int[] nums1,int[]nums2){
        Arrays.sort(nums1); Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> list =new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if( nums1[i] < nums2[j]){ //since all elements are sorted and in ascending order if its not equal value in both array then simply just increment there pointers
                i++;
            }else {
                j++;
            }
        }
        int[] result = new int[list.size()];
        for(int k=0 ; k < list.size(); k++){
            result[k]= list.get(k);
        }
        return result;
    }

}
