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
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while(n>0){
            fast = fast.next;
            n-=1;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        //slow.next = fast
        //被删除节点没有真正断掉
        slow.next = slow.next.next;
        return dummy.next;
    }
}
