package com.milu.milu.动态规划;

public class _36_583_两个字符串的删除操作 {


    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("leetcode", "etco"));
    }

    /**
     * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     *
     * 每步 可以删除任意一个字符串中的一个字符。
     *
     * dp[i][j]: 限定 i 长度的word1，和限定 j 长度的word2，他们需要删除dp[i][j]
     *
     * 状态转移过程
     * 边界情况，如果两个word，都删除成空，就相等
     *
     * 当前字母是否要删除，就看当前字母是否一样，一样就可以不用删除，也可以删除，
     * 不相同则 dp[i][j] = min ( dp[i-1][j-1] , dp[i-1][j] , dp[i][j-1] )
     * 相同，则dp[i][j] = dp[i-1][j-1]
     *
     * 初始化
     * 另一个word是i，那么删除需要将另一个word全部删除
     *
     */

    public static int minDistance(String word1, String word2) {
        //dp[][]
        int[][] dp = new int[word1.length()][word2.length()];

        //初始化
        for(int i = 0 ; i < word1.length(); i++){
            dp[i][0] = i;
        }
        for(int j = 0 ; j < word2.length(); j++){
            dp[0][j] = j;
        }

        for(int i = 1 ; i < word1.length();i++){
            for(int j = 1; j < word2.length(); j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1] + 2 , Math.min(dp[i-1][j]+1,dp[i][j-1] +1));
                }
            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }
}
