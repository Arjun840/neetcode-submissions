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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // check the value of each list, put the smaller value
        // edge case is when they're different lengths, you need to add
        // the remaining nodes onto the end
        // we need a dummy and a result, because at the end the result will be pointing
        // to the end of the result and we need the beginning 
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                res.next = list1;
                list1 = list1.next;
            } else{
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null){
            res.next = list1;
        } else if (list2 != null){
            res.next = list2;
        }
        return dummy.next;
    }
}