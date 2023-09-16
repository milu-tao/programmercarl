package com.milu.work.去哪儿;

import java.util.HashSet;
import java.util.Set;

public class _3_ {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(lengthL(node));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 单向链表长度
     * @param head ListNode类 链表头节点
     * @return int整型
     */
    public static int lengthL(ListNode head) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        while (head != null){
            if(set.contains(head.val)){
                //存在则跳过，要去重
                head = head.next;
            }else{
                set.add(head.val);
                head = head.next;
                result ++;
            }
        }
        return result;

    }


    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

