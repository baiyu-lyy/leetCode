package com.lyy.fengxiao.order;

/**
 * 递归
 *
 * @Author: 白榆
 * @Date: 2021/9/6 10:54 上午
 */
public class order_24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode first = head.next;
        head.next = first.next;
        first.next = head;
        swap(head, head.next);
        return first;
    }

    private static void swap(ListNode pre, ListNode current) {
        if (current == null || current.next == null) {
            return;
        }
        final ListNode next = current.next;
        current.next = next.next;
        next.next = current;
        pre.next = next;
        swap(current, current.next);
    }

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

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node1 = swapPairs(node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
