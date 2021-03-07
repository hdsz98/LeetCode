package com.linkedlist;
/*
    Easy
        编写一个程序，找到两个单链表相交的起始节点。
 */
public class LeetCode0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = 0, n2 = 0;
        ListNode tempA = headA, tempB = headB;
        while (tempA != null){
            n1++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            n2++;
            tempB = tempB.next;
        }
        if (n1 < n2) {
            tempA = headA;
            headA = headB;
            headB = tempA;
            int n = n1;
            n1 = n2;
            n2 = n;
        }
        for (int i = 0; i < n1 - n2; i++)
            headA = headA.next;
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
