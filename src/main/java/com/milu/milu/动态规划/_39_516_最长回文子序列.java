package com.milu.milu.动态规划;

public class _39_516_最长回文子序列 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    /**
     *
     * 题目：
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     *
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     *
     *
     * dp[i][j] :在i到j的字符串中，最长的回文子串是什么
     * 如果s.charAt(i) == s.charAt(j)  那么，我们就需要，dp[i+1][j-1] + 2
     *
     */

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        //初始化
        for (int i = 0; i < s.length(); i++) dp[i][i] = 1;

        for(int i = s.length() - 1 ; i >= 0 ; i--){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp [i+1][j-1] +2;
                }else  {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);

                }
            }
        }
        return dp[0][s.length()-1];
    }
}
