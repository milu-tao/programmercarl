package com.milu.milu.二叉树.base;

import sun.misc.LRUCache;

public class TreeNode {

    public int val;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(TreeNode left,TreeNode right, int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode( int val){
        this.val = val;
    }
}
