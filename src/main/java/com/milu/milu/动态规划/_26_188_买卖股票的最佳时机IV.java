package com.milu.milu.动态规划;


public class _26_188_买卖股票的最佳时机IV {
    public static void main(String[] args) {

    }

    public int maxProfit(int k, int[] prices) {
        //dp[i]:今天的状态是j，持有的金钱是dp[i] 奇数是：持有，偶数是不持有
        int[] dp = new int[k*2];
        //初始化
        for(int i = 0; i <k ;i ++){
            dp[i*2] = - prices[0];
        }
        for(int i = 1 ; i < prices.length; i++){
            //持有
            dp[0] = Math.max(dp[0],-prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            //用循环 但第0次是 -prices[]
            for(int j = 1; j < k; j++) {
                dp[j*2] = Math.max(dp[j*2], dp[j*2 -1] -prices[i]);
                dp[j*2 +1] = Math.max(dp[j*2+1] , dp[j*2] + prices[i]);
            }
        }
        return dp[k*2-1] ;
    }
}