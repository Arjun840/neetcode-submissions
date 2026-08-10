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
        // We'll use fast and slow pointer to find the middle of linked list
        // We'll reverse the second half and then merge them to get the
        // reordered list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){ // find middle
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null){ // reverse second half
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // Now take node by node from each list to reorder
        ListNode first = head;
        second = prev;
        while (second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
