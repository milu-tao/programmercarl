package com.milu.milu.动态规划;

public class _24_122_买卖股票的最佳时机II {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));//4
    }

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     *
     *
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        //0：持股，1：不持股
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }
        return dp[length-1][1];
    }

    /**
     * 因为有无数次，所以每次只要涨了就买
     */
    public static int maxProfit2(int[] prices) {
        int result = 0;
        for(int i = 1 ; i < prices.length;i++){
            result+= Math.max(prices[i]- prices[i-1],0);
        }
        return result;
    }
}
