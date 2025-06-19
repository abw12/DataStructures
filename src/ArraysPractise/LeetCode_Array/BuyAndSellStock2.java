package ArraysPractise.LeetCode_Array;

/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

 On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 However, you can buy it then immediately sell it on the same day.

 Find and return the maximum profit you can achieve.*/

public class BuyAndSellStock2 {
    /*
            profit: maximum total profit.
            buy: the day when buy stock.
            sell: the day when sell stock.
            days: maximum trade days.
        */
    public static void main(String[] args) {
        int[] prices = {3,7,1,5,8,2};
//        1,20,13,4,5,60

        int profit=0,buy=0,sell=0,days=prices.length;

        while (buy < days && sell < days){
            while( buy < days-1 && prices[buy + 1] < prices[buy])
                buy++;

            sell=buy;

            while(sell < days-1 && prices[sell+1] > prices[sell])
                  sell++;

            profit +=prices[sell] -prices[buy];

            buy=sell + 1;
        }
        System.out.println("maximum Profit is : " +profit);
    }
}
