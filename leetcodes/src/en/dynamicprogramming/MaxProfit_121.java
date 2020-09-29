package en.dynamicprogramming;

public class MaxProfit_121 {

//    假设您有一个数组，第i个元素是第i天给定股票的价格。
//    如果只允许您最多完成一笔交易（即买入和卖出一股股票），则设计一种算法以找到最大的利润。
//    请注意，您不能在买股票之前卖出股票。

//    出售的价格必须大于买入的价格

    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length > 1){
            int min = prices[0];

//            遍历数组找到最小的元素
            for(int i = 1; i < prices.length; i ++){
                min = Math.min(min, prices[i]);
//                获取当前元素与最小元素之差的最大值，并返回
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;

    }

    public int maxProfit1(int [] prices){
        if(prices.length == 0){
            return 0;
        }

        int [] dp = new int[prices.length];
        dp[0] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i] = Math.max(dp[i-1] + prices[i] - prices[i-1], 0);
        }

        int max = 0;
        for(int i= 0; i < prices.length; i ++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
