package LeetCode.BinarySearch;

import java.util.Arrays;

public class SpellsAndPotions {

    private static int[] successfulPairs(int[] spells, int[] potions, long success){
        //sort the potions array in ascending order
        Arrays.sort(potions);
        int potionsLength = potions.length;
        int spellsLength = spells.length;
        int[] result = new int[spellsLength];
        //use binary search on potions array to find the point where product is no more greater than or equal to success
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
