package com.milu.milu.动态规划;

public class _4_63_不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp ：走到（i，j）的位置一共有dp[i][j]种方法
        int[][] dp = new int[m][n];

        //初始化 ，考虑有障碍物的情况
        for(int i = 0 ; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                dp[i][0] = 1;

            }
        }
        for(int i = 0 ; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }else{
                dp[0][i] = 1;
            }
        }

        for(int i = 1; i < m ; i ++){
            for(int j = 1; j < n ; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
