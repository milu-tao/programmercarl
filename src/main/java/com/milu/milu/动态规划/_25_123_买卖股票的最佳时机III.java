package com.milu.milu.动态规划;

public class _25_123_买卖股票的最佳时机III {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit2(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public static int maxProfit(int[] prices) {
        //0 : 第一次持有 1 ： 第一次不持有 2 ：第二持有 3 ： 第二次不持有
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], -prices[i] );
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] );
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] - prices[i] );
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] + prices[i]);
        }
        return dp[prices.length-1][3];
    }

    /**
     * 空间压缩
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        //0 : 第一次持有 1 ： 第一次不持有 2 ：第二持有 3 ： 第二次不持有
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[2] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[0] = Math.max(dp[0], -prices[i] );
            dp[1] = Math.max(dp[1], dp[0] + prices[i] );
            dp[2] = Math.max(dp[2], dp[1] - prices[i] );
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}
