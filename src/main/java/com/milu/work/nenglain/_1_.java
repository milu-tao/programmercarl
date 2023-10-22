package com.milu.work.nenglain;

import java.util.Scanner;

public class _1_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        //dp:在0-i物体中，容量下能存的最大数量能放入的最大体积
        int[] dp = new int[number];

        //初始化，
        for (int i = nums[0]; i < number; i++) {
            dp[i] = nums[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = number - 1; j >= i; j--) {
//                dp[j] = Math.max(dp[j], dp[j - i] + nums[i]);

                if(dp[j] < dp[j-1] + nums[i] && nums[i] + dp[j-1] < j){
                    dp[j] = dp[j-1] + nums[i];
                }
            }
        }
        System.out.println(number - dp[number - 1]);

    }
}
