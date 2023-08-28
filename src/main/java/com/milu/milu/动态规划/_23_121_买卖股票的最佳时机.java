package com.milu.milu.动态规划;

import java.util.PriorityQueue;

public class _23_121_买卖股票的最佳时机 {
    public static void main(String[] args) {
//        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit1(new int[]{7, 6, 4, 3, 1}));
//        System.out.println(maxProfit1(new int[]{1, 4, 2}));//3
        System.out.println(maxProfit2(new int[]{3, 2, 6, 5, 0, 3}));//4
    }

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
     *
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
     *
     * 关键词:[“只能买入一次”]
     */
    //贪心，找
    public static int maxProfit1(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for(int i =0 ; i <prices.length;i++){
            low = Math.min(low,prices[i]);
            result = Math.max(result,prices[i] - low);
        }
        return result;
    }

    /**
     * dp数组得是二维的，首先，一维是不够的，因为买是一个从某天开始，并没有记录买了没有
     */
    public static int maxProfit2(int[] prices) {
        //0持有 1不持有
        //dp: 第i天【不】持有股票拥有的最大现金
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        //
        for(int i = 1; i < dp.length; i++){
            //主要在这里的状态转移
            //持有：之前就持有，今天买入。提示是一次购买，所有都是0-prices[i]
            //不持有：之前就不持有（dp[i-1][1]），今天卖出(dp[i-1][0] + prices[i])，
            dp[i][0] = Math.max(dp[i-1][0] , -prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }

        return dp[prices.length-1][1];
    }

}
