package com.milu.milu.二叉树;

import com.milu.milu.二叉树.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;

public class _1_二叉树的遍历 {
    public static void main(String[] args) {
        //测试数据
        /**
         *     5
         *    4   8
         *   9 6 1 2
         *
         *   前： 5 4 9 6 8 1 2
         *   中： 9 4 6 5 1 8 2
         */
        TreeNode left = new TreeNode(new TreeNode(9),new TreeNode(6),4);
        TreeNode right =  new TreeNode(new TreeNode(1),new TreeNode(2),8);
        TreeNode root = new TreeNode(left,right,5);

        List<Integer> result = preorderTraversal(root);
        System.out.println(result);

        List<Integer> preorderTraversalStack = preorderTraversalStack(root);
        System.out.println(preorderTraversalStack);

        List<Integer> inorderTraversal = inorderTraversal(root);
        System.out.println(inorderTraversal);


    }
    /**
     * 对于二叉树的遍历，递归遍历比较简单，写一遍
     *
     * 之后写一遍利用 栈 实现，前序和中序
     *
     * 之后写一遍 通用方法
     */

    //递归法，前序遍历
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        pre(root,list);

        return list;
    }

    public static void pre(TreeNode node,List<Integer> list){
        if(node == null) {
            return;
        }
        list.add(node.val);
        pre(node.left,list);
        pre(node.right,list);
    }

    //栈，前序遍历

    /**
     * 中前后，我们需要拿stack中的元素，然后逐步拿出来
     */
    public static List<Integer> preorderTraversalStack(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (! stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            //应该先放入右，再放入左
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }

    //中序遍历
    /**
     *  过程：
     *  1. 中序遍历，左中右，需要将节点锁定到这个字数的最左（存在在循环的过程中，stack暂时是没有放入元素的，因此循环条件不能仅仅是stack不为空）
     *  2. 当栈中元素就需要拿出来，
     */
    public static List<Integer> inorderTraversal(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(node != null || !stack.isEmpty()){
            if(node !=  null){
                //这里就是往左走，一直找到根节点的地方，在这个过程中，就需要将节点不停的放入stack中
                stack.add(node);
                node = node.left;
            }else{
                node = stack.pop();
                list.add(node.val);
                //这个时候将node的right节点复制给node，让他再去找while循环，这样node的right，他要是还有left，也需要先打印他们
                node = node.right;
            }
        }
        return list;
    }

}
