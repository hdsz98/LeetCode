package com.linkedlist;
/*
    Easy
        给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class LeetCode0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head, after = head.next;
        while (after != null) {
            if (after.val != pre.val){
                pre = pre.next;
                after = after.next;
            }
            else {
                while (after != null && after.val == pre.val)
                    after = after.next;
                pre.next = after;
                if (after == null)
                    return head;
                pre = after;
                after = after.next;
            }
        }
        return head;
    }
}
