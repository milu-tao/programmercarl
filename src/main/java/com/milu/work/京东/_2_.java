package com.milu.work.京东;

import java.util.Scanner;

public class _2_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int bag = in.nextInt();
//        int[][] strings = new int[n][4];
//        //0 正确消耗 1 正确得分 2 暴力消耗 3 暴力得分
//        for(int i = 0; i < n; i++){
//            strings[i][0] = in.nextInt();
//            strings[i][1] = in.nextInt();
//            strings[i][2] = in.nextInt();
//            strings[i][3] = in.nextInt();
//        }

        int n = 3;
        int bag = 10;
        int[][] strings = new int[n][4];
        //0 正确消耗 1 正确得分 2 暴力消耗 3 暴力得分


        strings[0][0] = 4;
        strings[0][1] = 10;
        strings[0][2] = 2;
        strings[0][3] = 5;

        strings[1][0] = 4;
        strings[1][1] = 10;
        strings[1][2] = 2;
        strings[1][3] = 5;

        strings[2][0] = 6;
        strings[2][1] = 20;
        strings[2][2] = 1;
        strings[2][3] = 15;

        String[] res = new String[bag + 1];

        int[] dp = new int[bag + 1];

        for (int i = 0; i < bag; i++) {
            if (i >= strings[0][0]) {
                dp[i] = strings[0][1];
                res[i] += "A";
            } else if (i >= strings[0][2]) {
                dp[i] = strings[0][3];
                res[i] += "B";
            } else {
                dp[i] = 0;
                res[i] += "F";
            }

        }


        //先物后包
        for(int i = 0; i < n; i++){
            for(int j = bag; j> 0;j--){
                if( j >= strings[i][0]){
                    dp[j] = Math.max(dp[j] , dp[j - strings[i][0]] + strings[i][1]);
                    res[i] += "A";
                }else if( j >= strings[i][2]){
                    dp[j] = Math.max(dp[j],dp[j-strings[i][2]] + strings[i][3]);
                    res[i] += "B";
                }else{
                    res[i] += "F";
                }
            }
        }
        System.out.println(res[bag]);

    }
}
