package com.linkedlist;
/*
    Medium
        给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

        你应当 保留 两个分区中每个节点的初始相对位置。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/partition-list
 */
public class LeetCode0086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode dummyHead1 = new ListNode(0), dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1, node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            }
            else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
