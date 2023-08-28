package com.milu.milu.动态规划;

public class _11_474_一和零 {
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * <p>
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     * <p>
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     * <p>
     * 我们需要返回 strs 的一个长度 。也就是这个背包能装的价值最大是多少（装越多越好）value都是1
     * dp[i][j] 在[0,z]物品中能装下的最打价值是dp[i][j]
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

//        //初始化 全是1


        for(int i = 0; i < strs.length; i++){
            int x = 0,y=0;
            for(char c : strs[i].toCharArray()){
                if(c == '0') x++;
                if(c == '1') y++;
            }

            for(int j = m; j >= x ; j--){
                for(int z = n; z >= y ; z--){
                    dp[j][z] = Math.max(dp[j][z] , dp[j-x][z-y] +1);
                }
            }
        }
        return dp[m][n];

    }
}
