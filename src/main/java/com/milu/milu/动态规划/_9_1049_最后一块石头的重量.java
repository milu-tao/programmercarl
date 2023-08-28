package com.milu.milu.动态规划;

public class _9_1049_最后一块石头的重量 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1})); //1
        System.out.println(lastStoneWeightII(new int[]{31,26,33,21,40})); //5

    }
    public  static int lastStoneWeightII(int[] stones) {
        //求得sum
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target  = sum/2;
        // dp: 在0~i之间能装满容量i的最大价值为dp[i]
        int[] dp = new int[target + 1];

        for (int i = stones[0]; i <= target; i++) {
            dp[i] = stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = target ; j >= 0; j--) {
                if (j - stones[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
        }
        return sum - 2 * dp[target];
    }
}
