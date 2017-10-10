/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1->2->5, 3->4->6 => 1->2->3->4->5->6
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val > n2.val) {
                    return 1;
                } else if (n1.val < n2.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        for (ListNode node: lists) {
            // be carefull
            if (node != null) {
                queue.add(node);
            }
        }
        
        while(!queue.isEmpty()) {
            ListNode node = queue.remove();
            dummyNode.next = node;
            dummyNode = dummyNode.next;
            
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        
        return head.next;
    }
}