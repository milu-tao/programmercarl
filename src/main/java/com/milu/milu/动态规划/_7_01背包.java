package com.milu.milu.动态规划;

public class _7_01背包 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(testWeightBagProblem1(weight, value, bagSize)); //35
        System.out.println(testWeightBagProblem2(weight, value, bagSize)); //35

    }

    /**
     * 二维dp
     */
    public static int testWeightBagProblem1(int[] weight, int[] value, int bagSize) {
        //dp: 在[0,i]中能装下j容量的背包的最大价值为dp[i][j]
        int[][] dp = new int[weight.length][bagSize + 1];

        //初始化
        // [i,0] 背包0能装下都是0
        // [0,j] 背包容量达到了j就可以是value[0]
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        //遍历顺序 遍历物品在遍历背包，在二维dp中。先遍历哪个都行，
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j - weight[i] >= 0) {
                    //为什么是根据i-1推测出来的呢？，因为当前i物品，装和不装都需要上一个状态，也就是0~i-1的之间dp最大价值去推断出来
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weight.length - 1][bagSize];
    }

    public static int testWeightBagProblem2(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];

        //初始化
        for(int i = weight[0]; i <= bagSize; i++ ){
            dp[i] = value[0];
        }

        for(int i = 0; i < weight.length; i++){
            //注意从后往前
            for(int j = bagSize ; j > 0; j--){
                if(j-weight[i]>= 0) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[bagSize];
    }
}
