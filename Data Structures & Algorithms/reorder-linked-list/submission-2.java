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
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == head) return;
        ListNode cur = slow.next;
        ListNode prev = slow.next;

        slow.next = null; 
        if (cur.next != null) {
           
            cur = cur.next; prev.next = null; 
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur; cur = next;
            }
        } // [head, ... , prev]
        while (prev != null) {
            ListNode next1 = head.next;
            ListNode next2 = prev.next;
            head.next = prev;
            prev.next = next1; 
            head = next1; prev = next2; 
        }

    }
}
