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
        // My intuition is to keep the first node because that will stay as 0
        // I then use two pointers, one at end and one at beginngin, and I
        // weave the solution by alternating which pointer to use
        ListNode fast = head;
        ListNode slow = head;
        // first we want to reverse
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode prev = slow.next;
        while (mid != null){
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }

        ListNode first = head;
        mid = prev;
        while (mid != null){
            ListNode temp1 = first.next;
            ListNode temp2 = mid.next;
            first.next = mid;
            mid.next = temp1;
            first = temp1;
            mid = temp2;
        }
    }
}
