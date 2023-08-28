package com.milu.milu.动态规划;

public class _2_70_爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        //防止边缘空指针情况
        if( n<= 1) return n;
        //dp数组: 爬到第i个台阶，一共有dp[i]种方法
        int[] dp = new int[n+1];
        //初始化
        dp[1] = 1;
        dp[2] = 2;
        //遍历顺序
        for(int i = 3 ; i <= n ; i++){
            //状态转移：一次可以爬2或1个台阶，第n个台阶就一定是第n-1上来和n-2上来的
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
}
