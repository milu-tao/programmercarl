package com.milu.milu.动态规划;

public class _27_309_最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfit1(new int[]{1, 2, 3, 0, 2}));

    }

    /**
     * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    /**
     * 0：不持有，1：持有 是之前的，已经不足够表达，因为不持有，有可能是在冷却器和不在冷却器，这一影响到，是否能在当天进行购买
     */
    public static int maxProfit(int[] prices) {
        // 0:持有，1：不持有，不在冷冻期中，2：不持有，在冷冻期中
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2] = dp[i-1][0] + prices[i];
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }

    /**
     * 空间压缩
     */
    public static int maxProfit1(int[] prices) {
        // 0:持有，1：不持有，不在冷冻期中，2：不持有，在冷冻期中
        int[] dp = new int[3];
        dp[0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[0] = Math.max(dp[0],dp[1] -prices[i]);
            dp[1] = Math.max(dp[1],dp[2]);
            dp[2] = dp[0] + prices[i];
        }
        return Math.max(dp[1],dp[2]);
    }
}
