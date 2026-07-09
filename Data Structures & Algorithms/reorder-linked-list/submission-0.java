/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode next = head.next;
        ListNode secondLast = head;
        ListNode last = head;
        while (last.next != null) {
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
        last.next = next;
        head.next = last;
        reorderList(next);
    }
}
