package com.milu.work.能链;

public class _1_ {

    public static void main(String[] args) {
        ListNode phead = new ListNode(1);
        phead.next = new ListNode(4);
        phead.next.next = new ListNode(3);
        ListNode partition = partition(phead, 4);
        System.out.println(1);
    }

    public static ListNode partition(ListNode pHead, int x) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        ListNode end = new ListNode(-1);
        ListNode endNode = end;
        while (pHead != null){
            if(pHead.val < x){
                node.next = new ListNode(pHead.val);
                node = node.next;
            }else{
                endNode.next = new ListNode(pHead.val);
                endNode = endNode.next;
            }
            pHead = pHead.next;
        }

        node.next = end.next;
        return head.next;
    }


    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
