package com.linkedlist;
/*
    Easy
        请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

    将目标节点的下一个节点复制到目标节点，然后跳过下一个节点
 */
public class LeetCode0237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
