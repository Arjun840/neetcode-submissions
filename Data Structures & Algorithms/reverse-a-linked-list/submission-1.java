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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null){
            ListNode temp = curr.next; // [1, 2, 3]
            curr.next = prev; // 1.next = null reverse direction
            prev = curr; // null -> 1
            curr = temp; // 1 -> 2
        }
        return prev;
    }
}
