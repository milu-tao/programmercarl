package com.milu.work.美团;

import java.time.temporal.ValueRange;
import java.util.Scanner;

public class _3_ {
    /**
     * 1. 看结果在哪里
     * 2
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//        int x = in.nextInt();
//        int y = in.nextInt();
//        int cake_value = 0;
//        int[][] cake = new int[x][y];
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                cake[i][j] = in.nextInt();
//                cake_value += cake[i][j];
//            }
//        }

        int[][] cake = new int[][]{{1, 1, 4}, {5, 1, 5}};
        int cake_value = 17;

        int a = shortCake(cake, cake_value);
        System.out.println(a);
    }

    private static int shortCake(int[][] cake, int cake_value) {
        //dp : 以（0，0）到(i,j) 的美味值是dp[i][j];
        int[][] dp = new int[cake.length][cake[0].length];

        int su1 = 0;
        for (int i = 0; i < cake.length; i++) {
            su1 += cake[i][0];
            dp[i][0] = su1;
        }
        int heng1 = 0;
        for (int j = 0; j < cake[0].length; j++) {
            heng1 += cake[0][j];
            dp[0][j] = heng1;
        }

        int cha = Integer.MAX_VALUE;

        int x=0,y =0;

        for (int i = 1; i < cake.length; i++) {
            for (int j = 1; j < cake[0].length; j++) {
                //新增一排，和新增一列
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + cake[i][j] - dp[i-1][j-1];

                if(cha > Math.abs(dp[i][j] - cake_value / 2)){
                    cha =  Math.abs(dp[i][j] - cake_value / 2);
                    x = i;
                    y = j;
                }
            }
        }

        //结果一定在后面那两个
        return Math.abs(2*dp[x][y] - cake_value);
    }
}
