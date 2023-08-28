package com.milu.milu.动态规划;

public class _15_70_爬楼梯_完全背包 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    /**
     * 转换成完全背包问题 ，求排列
     * dp[0] = 1，完全是因为递推公式而来，
     *
     * 先背包在物品，这样就能是排列的顺序
     */
    public static int climbStairs(int n) {
        //dp ：装满j容量的大小一共有dp[j]种方法
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int j = 1; j <= n; j++){
            for(int  i = 1; i <= 2; i++){
                if(j-i >=0) {
                    dp[j] += dp[j - i];
                }
            }
        }
        return dp[n];
    }
}
