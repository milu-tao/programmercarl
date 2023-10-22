package com.milu.work._360_;

import java.util.Scanner;

public class _1_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i = 0 ; i < count; i++){
            int manCount = in.nextInt();
            int need = in.nextInt();
            int[] manPower = new int[manCount];
            for(int j = 0 ; j < manCount; j++){
                manPower[j] = in.nextInt();
            }
            System.out.println();
            getCount(manCount,need,manPower);
        }
    }

    /**
     *
     * @param manCount 员工人数
     * @param need 需要的能力值
     * @param manPower 员工能力
     *
     * 状态转移：当前状态
     */
    private static void getCount(int manCount, int need, int[] manPower) {
        System.out.println(countWays(manPower,need,manCount,0,0));
    }
    //当前存入的对象
//    private static int[] path = new int[];

    private static int countWays(int[] manPower, int need, int manCount, int index, int have) {
        if(have >= need){
            return 1;
        }
        if(index >= manCount){
            return 0;
        }

        return 1;
    }
}
