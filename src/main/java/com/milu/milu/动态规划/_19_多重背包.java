package com.milu.milu.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _19_多重背包 {

    /**
     * 多重背包：我理解介于完全背包和01背包之间，物品不是无限的，但也有多个 ,将物品扩展出来，就变成01背包问题
     */
    public static void main(String[] args) {

        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        // dp: 容量i能装下的最大价值
        int[] dp = new int[bagWeight + 1];

        //先物后包
        for (int i = 0; i < nums.size(); i++) {
            for (int z = 0; z < nums.get(i); z++) {
                for (int j = bagWeight; j >= weight.get(i); j--) {
                    dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
                }
            }
        }
        System.out.println(dp[bagWeight]);
    }
}
