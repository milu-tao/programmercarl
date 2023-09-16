package com.milu.milu.动态规划;

public class _35_115_不同的子序列 {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));//3
    }

    /**
     * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模
     *
     *  dp: 以i-1 为结尾的s。具有以j-1结尾的t，一共出现了dp[i][j]
     *
     *  无论s[i-1]，t[j-1]是不是相等，dp[i][j] 都包含，dp[i-1][j]，不考虑s的最后一个字符，其中t出现的次数，
     *  如果s[i-1] == t[j-1] 。那么 需要多加dp[i-1][j-1],
     *  s在逐渐往后移的过程中，如果s的最后一个单词和t的最后一个单词相等，那么就等于s和t都划掉最后一个单词的结果 + s最后一个单词划掉
     *
     *  为什么是dp[i-1][j] ， s的子序列出现t的个数，他们不相等，那么当前就等于，s删除最后一个单词中后的子序列出现t的个数
     */
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];


        for(int i = 0; i <= s.length();i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1 ; j <= t.length(); j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
