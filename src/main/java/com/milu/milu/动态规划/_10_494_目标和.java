package com.milu.milu.动态规划;

public class _10_494_目标和 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1},3)); //5
        System.out.println(findTargetSumWays(new int[]{1},2)); //0
        System.out.println(findTargetSumWays(new int[]{100},-200));
    }

    /**
     *  也是01背包问题，但我们需要解析出targer，的关系
     *  target是3的是，意味两个推至今差距是3
     *  那么我们求组合
     */
    public static int findTargetSumWays(int[] nums, int target) {
        //求得sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int result = (sum + target)/2;
        // dp: 在0~i之间,装满j容量的背包一共有dp[j]种方法
        if((target + sum)% 2 == 1) return 0;
        if(Math.abs(target) > sum ) return 0;
        int[] dp = new int[result + 1];

        //初始化 从题目的意义上得不出该等于什么，从递推公式中可以看出来是有dp[0]推测出来的，所以dp[0] = 1
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = result ; j >= nums[i]; j--) {
                //求得是组合数，所以按照当前的物品i添加进来，有没有多一种可能加起来，最后累加起来 ，多一个i，然后推算
               dp[j] += dp[j - nums[i]];
            }
        }
        return dp[result];
    }
}
