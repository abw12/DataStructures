package LeetCode.BinarySearch;

import java.util.Arrays;

/*You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents
the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths
is at least success.

Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair
with the ith spell.

Example 1:

Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
        - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
        Thus, [4,0,3] is returned.*/

public class SpellsAndPotions {

    private static int[] successfulPairs(int[] spells, int[] potions, long success){
        //sort the potions array in ascending order
        Arrays.sort(potions);
        int potionsLength = potions.length;
        int spellsLength = spells.length;
        int[] result = new int[spellsLength];
        //use binary search on potions array to find the point where product is not greater than or equal to success
        for(int i = 0; i < spellsLength; i++){
            int l = 0;
            int r = potionsLength-1;
            while(l <= r){
                int mid = l + (r-l)/2;
                long product = (long) spells[i] * potions[mid];
                if(product >= success){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            result[i] = potionsLength - l;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        long success = 7;

        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }
}
