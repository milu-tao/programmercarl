package com.milu.milu.动态规划;

public class _8_416_分割等和子集 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }

    /**
     * 题目：给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * 本质是01背包，装满sum/2，能装满就意味着能分割成等和子集 ，价值和重量都是nums[]
     */
    public static boolean canPartition(int[] nums) {
        //求得sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target  = sum/2;
        // dp: 在0~i之间能装满容量i的最大价值为dp[i]
        int[] dp = new int[target + 1];

        for (int i = nums[0]; i <= target; i++) {
            dp[i] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = target ; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[target] == target;
    }
}
