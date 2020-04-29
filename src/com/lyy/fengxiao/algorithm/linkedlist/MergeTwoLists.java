package com.lyy.fengxiao.algorithm.linkedlist;

public class MergeTwoLists {

    /**
     * 问题描述：21
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 解题思路：
     * 非递归：就是新建一个链表用来存最终的节点。从头循环遍历两个链表，并比较每个节点，
     * 小的节点放入到新的链表中，然后继续比较，直到结束。
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 非递归方式
     * @param l1 节点
     * @param l2 节点
     * @return  节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }

        ListNode head=null;
        if (l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }else {
            head=l2;
            l2=l2.next;
        }

        ListNode first=head;

        while (l1!=null || l2!=null){
            if (l1==null){
                first.next=l2;
                l2=l2.next;
                first=first.next;
                continue;
            }
            if (l2==null){
                first.next=l1;
                first=first.next;
                l1=l1.next;
                continue;
            }

            if (l1.val<=l2.val){
                first.next=l1;
                l1=l1.next;
                first=first.next;
            }else {
                first.next=l2;
                l2=l2.next;
                first=first.next;
            }
        }

        return head;
    }

    /**
     * 递归方式
     * @param l1 节点
     * @param l2 节点
     * @return  节点
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }

        if (l2==null){
            return l1;
        }

        if (l1.val<l2.val){
            l1.next=mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }

}
