package com.lyy.fengxiao.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {

    /**
     *
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     * 说明：不允许修改给定的链表。
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     **/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * hash,使用两个map
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null){
            return null;
        }

        Map<ListNode,Integer> map=new HashMap<>();
        Map<Integer,ListNode> map1=new HashMap<>();
        int index=0;
        while (head!=null){
            if (map.containsKey(head)){
                return map1.get(map.get(head));
            }else {
                map.put(head,index);
                map1.put(index,head);
            }
            index++;
            head=head.next;
        }

        return null;
    }

    /**
     * 快慢指针:两次指针。
     * 假设链表非环的长度为a，环的长度为b
     * 由于快指针一次走两步，慢指针一次走一步，所以快指针的步数f是慢指针步数s的2倍，即f=2s。
     * 且到相遇时，快指针走的步数比慢指针走的步数多nb，即f-s=nb
     * 由以上两个公式相减得到f=2nb,s=nb.
     * 我们知道从链表首节点走到环的入口处所需要走a+nb步长才行，也就是说在快慢指针相遇的地方，慢指针在走a步在次走到环的入口处。
     * 那么如何确定a是多少呢？我们知道链表的非环长度为a，那么我们就可以在从首节点出发走a步和慢指针相遇，此时慢指针所在的位置即是环的入口
     */
    public ListNode detectCycle1(ListNode head) {
        if (head==null || head.next==null){
            return null;
        }

        ListNode fast=head.next.next;
        ListNode slow=head.next;
        while (fast!=null && slow!=null){
            if (fast==slow){
                break;
            }
            if (fast.next==null || fast.next.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }

        if (fast!=slow){
            return null;
        }

        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }

        return slow;
    }
}
