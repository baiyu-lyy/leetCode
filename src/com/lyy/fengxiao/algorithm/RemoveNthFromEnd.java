package com.lyy.fengxiao.algorithm;

public class RemoveNthFromEnd {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null){
            return null;
        }
        //删除倒数第n个，就是从前往后第 节点个数-n+1 位置上的节点
        int count=0;
        ListNode first=head;
        while (first!=null){
            count++;
            first=first.next;
        }

        int index=count+1-n;
        if (index==1){
            return head.next;
        }

        first=head;
        count=1;
        ListNode pre=head;
        while (first!=null){
            if (count==index){
                pre.next=first.next;
                break;
            }
            count++;
            pre=first;
            first=first.next;
        }

        return head;
    }
}
