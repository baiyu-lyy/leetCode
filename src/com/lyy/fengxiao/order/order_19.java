package com.lyy.fengxiao.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 白榆
 * @Date: 2021/8/25 8:56 下午
 */
public class order_19 {
    //数组
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        final int size = listNodes.size();
        final int index = size - n;
        if (index == 0) {
            return size == 1 ? null : listNodes.get(1);
        }
        final ListNode preNode = listNodes.get(index - 1);
        preNode.next = listNodes.get(index + 1);
        return listNodes.get(0);
    }

    //双指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode first = head;
        int count = 1;
        if (n == 1) {
            head = head.next;
            return head;
        }
        while (count != n) {
            head = head.next;
            count++;
        }

        ListNode start = first;
        ListNode pre = start;
        while (head.next != null) {
            head = head.next;
            start = start.next;
            pre = start;
        }
        pre.next=start.next;
        return first;
    }

    private class ListNode {
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
}
