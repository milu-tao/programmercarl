package com.milu.milu.动态规划;

import java.util.Arrays;

public class _29_300_最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); //4
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4
    }
    /**
     * 题目：
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     */

    public static int lengthOfLIS(int[] nums) {
        //dp:数组的含义 在这种之前的最长的递增子序列 or 包括最后一个字母的最长递增子序列
        // 明显第二张能顺便知道最后一个的字母是啥
        int[] dp = new int[nums.length];

        //初始化：包括最后一个字段的初始化，都 应该是1
        for(int i = 0 ; i < nums.length; i++){
            dp[i] = 1;
        }

        int max = 0;
        for(int  i =1 ; i < nums.length; i++){
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] ,dp [j] +1 );
                }
                max = Math.max(dp[i] , max);
            }
        }
        return max;
    }

}
