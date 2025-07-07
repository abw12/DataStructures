package LeetCode.Hashtables;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
    //both the solution works similarly with same time complexity using the concept of remainder
        // Solution 1: self solved
    // Set<Integer> numSet = new HashSet<>();
    // while(numSet.add(n)){
    //     int curr_sum=0;
    //     while(n > 0){
    //         int digit = n%10;
    //         curr_sum += digit*digit;
    //         n = n/10;
    //     }
    //     if (curr_sum == 1){
    //         return true;
    //     }
    //     n=curr_sum;
    // }
    // return false;
        //solution 2: same concept Leetcode solutions section
    Set<Integer> visit = new HashSet<>();

        while (!visit.contains(n)) {
        visit.add(n);
        n = getNextNumber(n);
        if (n == 1) {
            return true;
        }
    }

        return false;
}

    private int getNextNumber(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n = n / 10;
        }

        return output;
    }
}
