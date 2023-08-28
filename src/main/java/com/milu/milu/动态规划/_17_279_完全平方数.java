package com.milu.milu.动态规划;

public class _17_279_完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     *
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     * 问题转换成，完全背包问题，n是背包大小，然后里面元素可以是有规律的，求装满最小的数量
     */

    public static int numSquares(int n) {
        // 在物品中，装满n大小的背包，最少的数量是dp[i]
        int[] dp = new int[n+1];

        //初始化：一开始假设，所有组成都很大
        for(int i = 0; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        //遍历顺序
        for(int i = 0; i*i <= n; i++){
            for(int j = i*i; j <= n; j++ ){
                if(dp[j - i*i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
