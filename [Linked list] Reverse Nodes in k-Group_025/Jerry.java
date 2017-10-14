/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //TODO fail, not completed
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        
        ListNode leftPrev = new ListNode(0);
        leftPrev.next =head;
        ListNode right = head;
        int count = 0;
        while(right != null) {
            count++;
            System.out.println("count:"+count+ " , "+right);
            
            if(count % k == 0) {
                // first reverse or added a dummy head
                if (count / k == 1) {
                    head = right;
                }
                leftPrev = reverseList(leftPrev, right);
                right = leftPrev.next;
                System.out.println("new leftprev:"+leftPrev+ ", new right "+right);
            } else {
                right = right.next;
            }
        }
        return head;
    }
    
    /* A---> (B->C->D) --> E    =>    A--> (D->C->B) --> E
        C->B
        D->C
        B->E
        A->D
        return B */
    private ListNode reverseList(ListNode prevhead, ListNode tail) {
        ListNode prev = prevhead;
        ListNode curr = prevhead.next;
        
        ListNode first = prevhead.next;
        ListNode end = tail.next;
        
        while(curr != tail) {
            ListNode next = curr.next;
            //B->A(X), C->B, D->C
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //B->E
        first.next = end;
        //A->D
        prevhead.next = tail;
        return first;
    }
}