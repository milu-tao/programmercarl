package com.milu.work.美团._819;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class _2_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n];
        for(int i =0; i < n; i++){
            dp[i] = in.nextInt();
        }
        int max = 0;
        for(int i = 0;i < n-1; i++){
            max = Math.max(max,dp[i] * dp[i+1] - dp[i] - dp[i+1]);
        }
        System.out.println(Arrays.stream(dp).sum() +max);

    }
}
