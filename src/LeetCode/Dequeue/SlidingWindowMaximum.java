package LeetCode.Dequeue;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr= {1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
        System.out.println(Arrays.toString(optimalSolution(arr, k)));
    }

    //naive solution which does not pass all the test cases in the leetcode ( time limit exceed)
    private static int[] maxSlidingWindow(int[] nums, int k){
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i <= nums.length-k;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i; j < i+k;j++){
                max = Math.max(max,nums[j]);
            }
            answer.add(max);
        }

        //convert the list to array of int[]
        //traditional
        int[] result = new int[answer.size()];
        for(int i=0; i < answer.size();i++){
            result[i] = answer.get(i);
        }
        return result;
    }

    //optimal solution of this problem is using the deque ( double ended queue)
    private static int[] optimalSolution(int[] nums, int k) {
        if(nums == null || k<=0) return new int[0];
        int n = nums.length;
        int[] res = new int[n-k+1];
        int resi = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<n;i++){
            while(!q.isEmpty() && q.peek() < i-k+1){ // remove out of window elements
                q.poll();
            }
            // remove smaller elements from right hand side
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i >= k-1){
                res[resi++] = nums[q.peek()];
            }
        }
        return res;
    }
}
