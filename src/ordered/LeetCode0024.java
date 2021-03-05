package ordered;
/*
    Medium
        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode0024 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head), res = pre;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = next;

            pre = pre.next.next;
            head = next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode res = new LeetCode0024().swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
