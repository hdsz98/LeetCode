package com.linkedlist;
/*
    Medium
        给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class LeetCode0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = new ListNode(0, head), res = pre;
        ListNode after = head.next;
        while (after != null) {
            if (after.val != head.val) {
                pre = pre.next;
                head = head.next;
                after = after.next;
            }
            else {
                while (after != null && after.val == head.val)
                    after = after.next;
                pre.next = after;
                if (after == null)
                    return res.next;
                head = after;
                after = after.next;
            }
        }
        return res.next;
    }
}
