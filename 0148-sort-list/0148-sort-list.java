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
    public ListNode sortList(ListNode head) {
        if(head == null) return head;

        ListNode curr = head;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        while(curr != null){
            q.offer(curr.val);
            curr = curr.next;
        }

        curr = new ListNode(q.poll());
        head = curr;
        while( !q.isEmpty() ){
            curr.next = new ListNode(q.poll());
            curr = curr.next;
        }
        return head;

    }
}