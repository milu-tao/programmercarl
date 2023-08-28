package com.milu.milu.动态规划;

public class _16_322_零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); //3
    }

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 完全背包，组合的方式
     */

    public static int coinChange(int[] coins, int amount) {
        //dp: 凑成j金额的最小硬币数
        int[] dp = new int[amount + 1];

        //初始化 ，不然都是0，min就都是0
        for(int  i = 0; i <dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        //初始化，不然下面的逻辑，一直是最大，进不去那个逻辑,一直是最大值,并且之后的状态都是从0开始推导出来的
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //这判断主要是，1. 防止最大值+1，变成一个很小的负数，影响判断，2.如果是最大值，就以为着，没办法凑，就不需要走这个对比的逻辑
                if(dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1:dp[amount];
    }
}
