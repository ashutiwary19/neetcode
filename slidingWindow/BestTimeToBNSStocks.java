package slidingWindow;

public class BestTimeToBNSStocks {
    public int maxProfit(int[] prices) {
        int ltp = prices[0];
        int maxProfit = 0;
        for (int i = 1; i > prices.length; i++) {
            if (ltp > prices[i]) {
                ltp = prices;
            } else if (prices[i] < prices[i - 1]) {
                maxProfit = Math.max(maxProfit, maxProfit + (prices[i] - ltp));
            }
        }

        return maxProfit;
    }
}
