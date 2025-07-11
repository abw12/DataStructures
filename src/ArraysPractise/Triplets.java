package ArraysPractise;

import java.util.*;


//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
// i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

//3sum problem and this is same only thing here we are checking the target as 0 all the time in 3sum you'll be provided with the target value
public class Triplets {
//    Time complexity: O(n^2)
//    Explanation: Sorting takes O(n logn) & 'for' loop and 'while' loop takes O(n^2) together. But since O(n^2) > O(nlogn). Therefore, O(n^2).
//    Space complexity: O(n)
//    Explanation: As the total elements are n and the space complexity will be some factor of n.
//    Therefore, after removing constant, we are left with O(n).
    //this is the best solution for the 3sum /triplet problem
    public static  List<List<Integer>> checkTriplets(int[] arr,int target){
        Set<List<Integer>> result = new HashSet<>();
        if(arr.length == 0) return new ArrayList<>(result);
        Arrays.sort(arr);
        for(int fixPointer=0 ; fixPointer < arr.length-2 ; fixPointer++){
            int startPointer = fixPointer+1; //always start from +1 position of the fixPointer index
            int endPointer = arr.length-1;  //last position of the array
            while(startPointer<endPointer){  //here we are using two pointer algorithm which takes O(n) linear time
                int sum=arr[fixPointer]+arr[startPointer]+arr[endPointer];
                if(sum == target) result.add(Arrays.asList(arr[fixPointer],arr[startPointer++],arr[endPointer--]));
                else if( sum > target) endPointer--;
                else if(sum < target ) startPointer++;
            }
        }

//        System.out.println("Triplets : " +result);
            return new ArrayList<>(result);
    }


    //here we using hash set to keep all input array values
    //it takes same o(n^2) time complexity
    //it uses extra space since are maintaining the hashset
    // o(n) is the space complexity
    private static boolean threeSumUsingHashing(int[] num,int target){

        for(int i=0 ; i < num.length-2 ; i ++){
            int curr_sum = target - num[i];
            Set<Integer> set = new HashSet<>();

            for(int j=i+1; j < num.length ; j++ ){

                if(set.contains(curr_sum - num[j])){
                    System.out.println("Triplets are: " + num[i] + "," +num[j] + "," + (curr_sum - num[j]) );
                    return true;
                }
                set.add(num[j]);
            }
        }
        return false;
    }

    //this solution is specifically for the 3sum question where target is zero
    // it doesn't make use of the target since we know we want 3 numbers whose sum is equal to 0
    private static List<List<Integer>> solution2(int[] arr){

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> z = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        List<Integer> n = new ArrayList<>();

        // iterate and form the three groups zeros,-ve,+ve
        for(Integer num:arr){
            if(num == 0){
                z.add(num);
            }else if(num > 0){
                p.add(num);
            }else{
                n.add(num);
            }
        }

        //create +ve and -ve sets for faster lookup
        Set<Integer> pSet = new HashSet<>(p); //+ve set
        Set<Integer> nSet = new HashSet<>(n); //-ve set

        // if all are zeros
        if(z.size() >=3 )
            result.add(List.of(0,0,0));

        // one +ve , one -ve and one zero (1,0,-1)
        if(!z.isEmpty()){
            for(Integer pos : p){
                if(nSet.contains(-pos)){
                    result.add(List.of(pos,0,-pos));
                }
            }
        }
        //{ -4,-1,-1,0,1,2,-2};
        //two +ve and one -ve (1,1,-2)
        if(!p.isEmpty()){
            for(int i=0 ; i < p.size() ; i++){
                int target = p.get(i);
                for(int j=i+1; j < p.size();j++){
                    target += p.get(j);
                    if(nSet.contains(-target)){
                        result.add(List.of(p.get(i),p.get(j),-target));
                    }
                }
            }
        }

        //two -ve and one +ve (-1,-1,2)
        if(!n.isEmpty()){
            for(int i=0 ; i < n.size() ; i++){
                int target = n.get(i);
                for(int j=i+1; j < n.size();j++){
                    target += n.get(j);
                    if(pSet.contains(-target)){
                        result.add(List.of(n.get(i),n.get(j),-target));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] input = {12, 3, 4, 1, 6, 9,8};
        int target1 = 24;
        int[] num = { 12, 3, 4, 1, 6, 9,8 };
        int target2 = 24;
        int[] num3Sum = { -4,-1,-1,0,1,2,-2}; //answer : [{-1,-1,2},{2,0,-2},{-1,0,1}]


        System.out.println("Triplets: " +checkTriplets(input,target1));
        System.out.println("is triplet present: "+ threeSumUsingHashing(num,target2));
        System.out.println("3sum using 2nd approach :: " + solution2(num3Sum));
    }
}
