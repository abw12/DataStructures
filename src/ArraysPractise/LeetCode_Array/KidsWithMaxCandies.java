package ArraysPractise.LeetCode_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class KidsWithMaxCandies {
//    O(n) time complexity though nota clean code
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        List<Boolean> ans=new ArrayList<Boolean>();
        int currentMaxCandies = candies[0];
        for(int i=0; i < len ; i++){
            if(currentMaxCandies < candies[i]){
                currentMaxCandies = candies[i];
            }
        }
        for(int i=0; i < len ; i++){
            if(candies[i] + extraCandies >= currentMaxCandies){
                ans.add(i,true);
            }
            else{
                ans.add(i,false);
            }
        }
        return ans;
    }

    //better and clean code no extra variable and check created O(n) time complexity
    public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = 0;
        for (int candy : candies) {
            max = max(candy, max);
        }
        for (int candy : candies) {
            ans.add(candy + extraCandies >= max);
        }
        return ans;
    }

    //how to od it in java8
    public static List<Boolean> java8Way(int[] candies,int extraCandies){
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] candies={1,3,9};
        int extraCandies=4;
        System.out.println(kidsWithCandies(candies,extraCandies).toString());
        System.out.println(kidsWithCandies2(candies,extraCandies).toString());
        System.out.println(java8Way(candies,extraCandies).toString());
    }
}
