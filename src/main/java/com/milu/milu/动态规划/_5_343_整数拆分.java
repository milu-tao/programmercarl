package com.milu.milu.动态规划;

public class _5_343_整数拆分 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    /**
     * 整数划分，用动态规划，那么我们需要考虑，当前值是由哪个状态转移过来的
     * 那么n，可以由dp[n-i]*i，转移过来，那么我们得到dp[i]的时候，都需要遍历之前的所有状态，取最大就行
     */
    public static int integerBreak(int n) {
        //dp: 数字i的最大乘积是dp[i]
        int[] dp = new int[n+1];
        //初始化，0可能没有意义，-0，还是那个数，所以从1开始
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            //这一层遍历是为了遍历i之前的所有元素，取最大，dp[i-j] * j一定是，三个数以上的相乘，没有包含2个数相乘，所以需要额外加上，对比这几个
           for(int j = 1; j <i; j++){
               dp[i] = Math.max(Math.max(dp[i],dp[i-j] * j), (i-j) * j);
           }
        }
        return dp[n];
    }
}
