package com.milu.milu.动态规划;

public class _13_518_零钱兑换 {
    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     *
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     *
     * 假设每一种面额的硬币有无限个。
     *
     * 题目数据保证结果符合 32 位带符号整数。
     *
     * 遍历顺序：
     * 先背包还是先物品，这个主要跟排序还是组合有关系，如果是先物品，就是当前物品放不放，同时顺序也是比较固定的[1,5]，永远是[1,5]，出现不了[5,1]
     */

    public static int change(int amount, int[] coins) {
        //dp：凑成i金额一共有dp[i]种组合
        int[] dp = new int[amount+1];

        //初始化
        dp[0] = 1;

        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
