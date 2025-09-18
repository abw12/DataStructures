package LeetCode.BinarySearch;


/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23*/

/*
Constraints:

        1 <= piles.length <= 104
        piles.length <= h <= 109
        1 <= piles[i] <= 109
*/


public class KokoEatingBananas {

    private static int isValid(int[] piles,int k){
        int total=0;
        for(int pile : piles){
            // we need to calculate the total hours required to eat all the bananas
            // if k is 3, then it will take 2 hours to eat 7 bananas
            total+=(pile + k-1)/k; // this is equivalent to Math.ceil(pile/k)
        }
        return total;
    }

    private static int minEatingSpeed(int[] piles, int h) {
        // this can be solved using the binary search algorithm
        int max =0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        //we got the range of our binary search
        // the minimum speed can be 1 and maximum speed can be max pile
        int low = 1; //left pointer for BS
        int high = max; //right pointer for BS

        while(low < high){
            int mid = low + (high - low)/2; //mid point for BS
            int res = isValid(piles,mid);
            if(res <= h) {
                high = mid; // if the total hours required is less than or equal to h, we can try to reduce the speed
            }else{
                low = mid + 1; // if the total hours required is more than h, we need to increase the speed
            }
        }
        return low; // when low and high meet, we have found the minimum speed required to eat all the bananas in h hours
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
