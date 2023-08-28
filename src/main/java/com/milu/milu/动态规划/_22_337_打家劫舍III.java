package com.milu.milu.动态规划;

import com.milu.milu.动态规划.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _22_337_打家劫舍III {
    public static void main(String[] args) {

    }

    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     *
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     *
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     *
     * 当前节点能不能投，取决于，他的的父节点有没有被偷
     *
     * 遍历树，一般我们都会想到用前序遍历还是后续遍历还是其他，所以我们可以使用递归，+ 动态规划
     *
     */
    //dp 存的是，到这里能偷的最大价值
    public static Map<TreeNode,Integer> dp = new HashMap<>();

    //记忆化递归，我理解其实更偏向动态规划一点。动态规划更多是当前状态可以由之前状态的状态退出来，也当做一种记忆
    public static int rob1(TreeNode root) {
        //递归的终止条件
        if(root == null) return 0;
        //如果当前是叶子节点，只考虑当前节点，能偷的最大就是把这个偷了
        if(root.left == null && root.right == null) return root.val;
        if(dp.get(root) != null) return dp.get(root);

        //分情况，分成父节点，偷和不偷
        //偷
        int val1 = root.val;
        if(root.left != null) val1 += rob1(root.left.left) + rob1(root.left.right);
        if(root.right != null) val1 += rob1(root.right.left) + rob1(root.right.right);

        //不偷
        int val2 = rob1(root.left) + rob1(root.right);
        int max = Math.max(val1, val2);
        dp.put(root,max);
        return max;
    }

    //树形dp，因为是递归进行遍历树，所以递归，我们只需要定义好本层的数据结果，在堆栈中会有一连串的dp数据
    public static int rob2(TreeNode root) {
        if(root == null) return 0;
        int[] robbion = robbion(root);
        return Math.max(robbion[0],robbion[1]);
    }

    private static int[] robbion(TreeNode root) {

        // 0：偷，1不偷
        int[] dp = new int[2];

        if(root == null) return dp;

        int[] left = robbion(root.left);
        int[] right = robbion( root.right);

        //偷
        dp[0] = root.val + left[1] + right[1];
        //不偷 左节点偷和不偷都不被限制，但是需要返回一个大值
        dp[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return dp;
    }
}
