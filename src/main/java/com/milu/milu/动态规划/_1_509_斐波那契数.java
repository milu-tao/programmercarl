package com.milu.milu.动态规划;

public class _1_509_斐波那契数 {

    /**
     * 题目： 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
     */
    public static void main(String[] args) {
        System.out.println(fib2(3));
    }

    // 非压缩版本
    public static int fib(int n) {
        if(n < 2) return n;
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i- 2];
        }
        return dp[n];
    }

    // 压缩版本
    public static int fib2(int n) {
        if(n < 2) return n;
        // 初始化
        int  a = 0, b = 1 , c =0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
