package com.lyy.fengxiao.order;

/**
 * @Author: 白榆
 * @Date: 2021/5/29 4:37 下午
 */
public class order_2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        boolean flag = false;
        if (l1 != null && l2 != null) {
            head.val = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
        } else if (l1 != null) {
            head.val = l1.val;
            l1 = l1.next;
        } else {
            head.val = l2.val;
            l2 = l2.next;
        }
        if (head.val >= 10) {
            head.val -= 10;
            flag=true;
        }
        ListNode node = head;
        while (l1 != null || l2 != null) {
            ListNode next = new ListNode();
            int sum;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            } else {
                sum = l2.val;
                l2 = l2.next;
            }
            if (flag) {
                flag = false;
                sum += 1;
            }
            if (sum >= 10) {
                flag = true;
                sum -= 10;
            }
            next.val = sum;
            node.next = next;
            node = next;
        }
        if (flag){
            node.next= new ListNode(1,null);
        }
        return head;
    }


    static class ListNode {
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
