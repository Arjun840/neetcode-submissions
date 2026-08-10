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
        // head: [0, 1, 2, 3, 4]
        // prev: null
        // temp = [1, 2, 3, 4]
        // prev.next = curr;
        // curr = curr.next;
        ListNode prev = null;
        ListNode curr = head; 
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev; // [0, 1, null]
            prev = curr; // shift pointers
            curr = temp; // shift pointers
        }
        return prev;
    }
}
