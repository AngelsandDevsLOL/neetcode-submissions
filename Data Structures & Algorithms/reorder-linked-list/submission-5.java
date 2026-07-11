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
        ListNode prev = slow.next;
        if (slow.next == null) return;
        else {
            ListNode sec = slow.next;
            slow.next = null;
            
            // reverse sec
            prev = null;
            while (sec != null) {
                ListNode n = sec.next;
                sec.next = prev;

                prev = sec;
                sec = n;
            }
        }

        // merge
        ListNode first = head;
        while (prev != null) {
            ListNode n1 = first.next;
            ListNode n2 = prev.next;

            first.next = prev;
            prev.next = n1;

            first = n1;
            prev = n2;
        }

    }
}

