package com.lyy.fengxiao.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 白榆
 * @Date: 2021/8/31 11:59 上午
 */
public class order_21 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode first;
        if (l1.val >= l2.val) {
            first = l2;
            l2 = l2.next;
        } else {
            first = l1;
            l1 = l1.next;
        }
        ListNode head = first;
        merge(head, l1, l2);
        return first;
    }

    private static void merge(ListNode head, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return;
        }
        if (l1 == null) {
            head.next = l2;
            return;
        }
        if (l2 == null) {
            head.next = l1;
            return;
        }
        if (l1.val >= l2.val) {
            head.next = l2;
            head = head.next;
            merge(head, l1, l2.next);
        }
        if (l1.val < l2.val) {
            head.next = l1;
            head = head.next;
            merge(head, l1.next, l2);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1, l2);
        List<Integer> values = new ArrayList<>();
        while (listNode != null) {
            values.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(values);
    }
}
