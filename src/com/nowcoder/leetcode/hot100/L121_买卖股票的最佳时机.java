package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/1/29.
 */
public class L121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];//第i天出最大利润
        dp[0] = 0;
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            int j = i-1;
            while (j >= 0) {
                if (prices[i] >= prices[j]) {
                    dp[i] = dp[j] + prices[i] - prices[j];
                    break;
                }
                j--;
            }
            if(j < 0) {
                dp[i] = 0;
            }
            maxValue = Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }


    //遍历一遍
    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;//最小的股值
        int maxprofit = 0;//最大的利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
