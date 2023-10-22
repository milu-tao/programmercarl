package com.milu.milu.动态规划;

public class _37_72_编辑距离 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }

    /**
     * 题目
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     *
     * 删除一个字符
     *
     * 替换一个字符
     *
     *
     *
     * dp[i][j]:以i-1结尾的w1，和以j-1结尾的w2，他们之间最少的操作数是dp[i][j]
     *
     * 删除和添加的操作，我们可以相当于一样的操作，增加一个元素，相当于删除一个元素
     * 则 dp[i][j] = dp[i-1][j] +1  或者dp[i][j-1] +1
     * 如果是替换dp[i][j] = dp[i-1][j-1] +1
     * 取最小那个
     *
     * 那么上面是删除，添加，编辑之间的关系，
     * 一般是我们遇到w1.charAt(i-1) 和w2.chatAt(j-1)的两个字母不太一样的时候，我们才需要这样对比
     *
     */
    public  static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

        for(int i =  1 ; i <= word1.length();i++){
            for(int j = 1 ;  j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) +1 ;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
