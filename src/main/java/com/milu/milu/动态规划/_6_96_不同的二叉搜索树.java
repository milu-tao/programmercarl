package com.milu.milu.动态规划;

public class _6_96_不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    /**
     *   动态规划，我们主要是过程可以推导出来，那么如果进行推导？
     *   我们可以知道几个节点可以构成几个二叉树是固定的，然后分成左一推，右一推，慢慢往多节点进行推导
     *   所以dp的含义：就是i个节点可以构成dp[i]二叉搜索树
     *   dp[i] = 需要将所有可能加起来，单一个dp[i] = dp[j-1] * dp[ i - j]
     */
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        //初始化 0主要是为了后面推导，所以是1，不然结果会都是0，我们也不需要理
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j -1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
