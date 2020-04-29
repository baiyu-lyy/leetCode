package com.lyy.fengxiao.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    /**
     * 题目描述：141。
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     *
     * 解题思路：
     * hash
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();

        while (head.next!=null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
            }
            head=head.next;
        }

        return false;
    }

    /**
     *
     * 快慢指针：快指针一次移动两个节点，慢指针一次移动两个节点，当慢指针和快指针相同时，表示是环。
     * 若快指针到达链表尾部，慢指针没有，则表示不是环
     */
    public boolean hasCycle1(ListNode head) {
        if(head==null){
            return false;
        }

        if (head.next==null){
            return false;
        }

        ListNode quick=head.next.next;
        ListNode slow=head.next;
        while (quick!=null &&slow!=null){
            if (quick==slow){
                return true;
            }
            //防止空指针异常
            if (quick.next==null || quick.next.next==null){
                return false;
            }
            quick=quick.next.next;
            slow=slow.next;
        }

        return false;
    }
}
