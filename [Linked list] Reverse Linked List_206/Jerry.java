/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // recursively, beat: 3.8% 
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }
    
    private ListNode helper(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        
        ListNode tempNext = curr.next;
        curr.next = prev;
        return helper(tempNext , curr);
    }
    
    // iteratively, beat: 25%
    public ListNode reverseList_old(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(head != null) {
            head = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        
        head = prev;
        return head;
    }
}