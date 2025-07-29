package LeetCode.BinarySearch;

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
