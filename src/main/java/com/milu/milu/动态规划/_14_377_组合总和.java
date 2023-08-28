package com.milu.milu.动态规划;

public class _14_377_组合总和 {
    public static void main(String[] args) {

        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }

    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * 题目数据保证答案符合 32 位整数范围。
     */

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        //初始化
        dp[0] = 1;

        // nums中的可以多次使用，求排列
        for(int j = 0; j <= target; j++ ){
            for(int i = 0; i < nums.length; i++){
                if(j-nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

}
