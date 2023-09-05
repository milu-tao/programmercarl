package com.milu.work.blbl;

import com.milu.milu.动态规划.base.TreeNode;

public class _3_ {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(root));

    }

    public static int longestUnivaluePath (TreeNode root) {
        if(root == null){
            return 0;
        }

        return getHight(root);

    }

    private static int getHight(TreeNode root) {
        if(root == null){
            return -1;
        }
        int left_height = getHight(root.left);
        int right_height = getHight(root.right);
        return Math.max(left_height,right_height) +1;
    }
}
