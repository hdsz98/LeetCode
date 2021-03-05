package ordered;

public class LeetCode0025 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0, head), res = pre;
        while (head != null) {
            ListNode next = head;
            int i = 0;
            while (i < k && next != null){
                next = next.next;
                i++;
            }
            if (i < k)
                return res.next;
            pre.next = null;
            while (head != next) {
                ListNode temp = head;
                head = head.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            while (pre.next != null)
                pre = pre.next;
            pre.next = next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new LeetCode0025().reverseKGroup(head, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
