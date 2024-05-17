package demos.leetcode.jp;

public class BestTimeToBuySellStop {
    // This is faster and give only the max profit
    public int maxProfit(int[] prices) {

        int len = prices.length;
        int profit = 0;
        int minPx = Integer.MAX_VALUE;

        for (int i=0;i<len;i++) {
            if (minPx > prices[i]) minPx = prices[i];
            else {
                int p = prices[i]-minPx;
                profit = profit > p ? profit : p;
            }
        }
        return profit;
    }

    // This is slower but givrs max profit for everyday
    public int maxProfit1(int[] prices) {

        int len = prices.length;
        int[] max = new int[len];
        max[len-1] = prices[len-1];
        for (int i=len-2;i>=0;i--) {
            max[i] = prices[i] > max[i+1] ? prices[i] : max[i+1];
        }
        int profit = 0;
        for (int i=0;i<len;i++) {
            int p = max[i]-prices[i];
            profit = profit > p ? profit : p;
        }
        return profit;
    }

}
