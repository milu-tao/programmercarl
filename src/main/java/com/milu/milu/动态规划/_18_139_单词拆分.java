package com.milu.milu.动态规划;

import sun.awt.windows.WPrinterJob;

import java.util.ArrayList;
import java.util.List;

public class _18_139_单词拆分 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("leet");
        strings.add("code");

        System.out.println(wordBreak("leetcode", strings));
    }

    /**
     * 题目
     *
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     * 问题转换：
     * s是背包，装Dict中的单词，只是这个weight需要去转换一下，几个单词就几个weight，并且能不能装下去，也需要一些列的判断
     *
     * 递推公式： [j,i]之间的单词在字典中，并且dp[j] =true ，那么dp[i] = true
     *
     * 关键词：[“完全背包”，“排列”]
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        //dp: 使用Dict中的单词，能不能组成0-i长度的前缀的s（String）
        boolean[] dp = new boolean[s.length()+ 1];

        //初始化：默认都不可以转换过来，但由于需要一个true转换过来，所以dp[0] = true
        dp[0] = true;

        //遍历顺序
        for(int j = 1; j <= s.length(); j++){
            for(String string : wordDict){
                int len = string.length();
                if(j >= len && dp[j-len] && string.equals(s.substring(j-len,j))){
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
