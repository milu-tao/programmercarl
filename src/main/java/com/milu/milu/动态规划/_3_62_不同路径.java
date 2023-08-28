package com.milu.milu.动态规划;

public class _3_62_不同路径 {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     */
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 28
    }
    public static int uniquePaths(int m, int n) {
        // dp[][]：走到（i，j）的位置，一共有dp[i][j]种方法
        int[][] dp = new int[m][n];
        //初始化
        for(int i = 0 ;i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n ; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m -1][n-1];
    }
}
