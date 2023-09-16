package com.milu.milu.动态规划;

public class _30_674_最长连续递增序列 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7})); // 3
        System.out.println(findLengthOfLCIS(new int[]{1})); //1
        System.out.println(findLengthOfLCIS1(new int[]{1, 3, 5, 4, 7})); // 3

    }

    /**
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * <p>
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     * <p>
     * 连续递增子序列
     */
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        //以最后nums[i]结尾的连续递增子序列是dp[i]
        int[] dp = new int[nums.length];

        //初始化
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i - 1] +1;
            }
            max  =  Math.max(dp[i],max);
        }
        return max;
    }

    /**
     * 空间压缩
     */
    public static int findLengthOfLCIS1(int[] nums) {
        if(nums.length < 2) return nums.length;
        //以最后nums[i]结尾的连续递增子序列是dp[i]
        int dp = 1;

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                dp = dp +1;
            }else{
                dp = 1;
            }
            max  =  Math.max(dp,max);
        }
        return max;
    }

}
