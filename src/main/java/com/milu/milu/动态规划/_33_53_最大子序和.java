package com.milu.milu.动态规划;

public class _33_53_最大子序和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     *  给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     *  子数组 是数组中的一个连续部分。
     */
    public static int maxSubArray(int[] nums) {
        int count = 0;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            max = Math.max(max,count);

            if(count < 0){
                count = 0;
            }
        }
        return max;
    }
}
