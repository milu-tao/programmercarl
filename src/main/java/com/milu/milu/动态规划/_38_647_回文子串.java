package com.milu.milu.动态规划;

import java.util.concurrent.CountDownLatch;

public class _38_647_回文子串 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    /**
     * 题目；
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     *
     * 首先dp[],如果是记录到现在具有几个回文子串，并不能找到对应的递归规律，首先我们需要得到一个中间状态，用来记录中间是不是回文子串
     * dp[i][j] : 以i到j的字符串是不是回文子串
     *
     * 递推公式：
     * 如果s.charAt(i) == s.charAt(i-1)  加上  dp[i+1][j-1]是回文子串，就能得出，dp[i][j]的值
     *
     */
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        //收集结果
        int result = 0;
        //根据递归公司去定义递归顺序
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    //编码细节，如果i和j的距离比较小（相同或者相差1，那么他们就是回文子串
                    if(j - i < 2){
                        result++;
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]){
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
