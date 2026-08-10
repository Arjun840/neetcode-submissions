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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // We will make two pointers a dummy and a right
        // We will move the right pointer n times to reach the nth
        // node, remove it, then return dummy
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        int index = 0;
        while (right != null && index < n){
            right = right.next;
            index++;
        }

        while (right != null){
            right = right.next;
            left = left.next;
        }
        // left is sitting right before the nth node from end so now we simply remove it
        left.next = left.next.next;
        return dummy.next; 

    }
}
