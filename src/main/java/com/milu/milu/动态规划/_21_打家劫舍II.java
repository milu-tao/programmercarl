package com.milu.milu.动态规划;

public class _21_打家劫舍II {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{0,0}));
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     *
     * 考侧重点：首位相连，经常会喜欢成环，之前笔试的时候，也遇到公司成环
     *
     * 成环，我们可以这样，去掉首部对比一次，去掉尾部对比一次
     */

    public static int rob(int[] nums) {
        if(nums.length == 1 ) return nums[0];
        return Math.max(robAction(nums,0, nums.length -2),robAction(nums,1,nums.length -1));
    }

    public static int robAction(int[] nums, int start, int end) {

        if(start == end) return nums[start];

        //能偷到的最大金额
        int[] dp = new int[nums.length];

        //初始化
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start+1]);

        for(int i = start + 2 ; i <= end; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[end];
    }
}
