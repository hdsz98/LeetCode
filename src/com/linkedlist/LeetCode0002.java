package com.linkedlist;
/*
    Mediun
        给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
        请你将两个数相加，并以相同形式返回一个表示和的链表。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/add-two-numbers
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LeetCode0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l1;
        if (l2 == null)
            return l2;
        ListNode pre1 = null, pre2 = null, head = l1;
        int res = 0, temp = 0;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + res;
            l1.val = temp % 10;
            res = temp / 10;
            pre1 = l1;
            pre2 = l2;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2 != null) {
            temp = l2.val + res;
            pre1.next = new ListNode(temp % 10);
            res = temp / 10;
            pre1 = pre1.next;
            l2 = l2.next;
        }
        while (l1 != null && res != 0) {
            temp = l1.val + res;
            l1.val = temp % 10;
            res = temp / 10;
            pre1 = pre1.next;
            l1 = l1.next;
        }
        if (res != 0) {
            pre1.next = new ListNode(res);
        }
        return head;
    }
}
