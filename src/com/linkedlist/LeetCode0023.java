package com.linkedlist;

import java.util.PriorityQueue;

/*
    Hard
        给你一个链表数组，每个链表都已经按升序排列。

        请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class LeetCode0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(), temp = dummyHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {return o1.val - o2.val;});
        for (ListNode listNode : lists) {
            if (listNode == null)
                continue;
            queue.add(listNode);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null)
                queue.add(node.next);
        }
        return dummyHead.next;
    }
}
