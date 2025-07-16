package LeetCode.Array;


//You can make only one transaction to find the maxProfit from all the stock
//buy and sell only once to get the maxProfit
public class BuyAndSellStock1 {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

        System.out.println(calculateProfit(arr));
    }

    private static int calculateProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE; //least so far
        int op = 0; // overall profit
        int pist = 0 ; //profit if sold today

        for(int i=0 ; i < prices.length ; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }

            pist = prices[i] - lsf;
            if(pist > op ){
                op=pist;
            }

        }
        return op;
    }
}
