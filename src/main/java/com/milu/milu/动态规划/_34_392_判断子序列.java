package com.milu.milu.动态规划;

public class _34_392_判断子序列 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));//true
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 两个字符串，用一个二维数组，从题目已经知道。s是比较小的。所以也可以将过程变成t，如果当前字符不是，就删除一个位的t
     *
     */
    public static boolean isSubsequence(String s, String t) {
        //dp:以i-1的s，j-1的t，他们的相同子序列是dp[i][j]
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i -1)  == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        if(dp[s.length()][t.length()] == s.length()){
            return true;
        }else{
            return false;
        }
    }
}
