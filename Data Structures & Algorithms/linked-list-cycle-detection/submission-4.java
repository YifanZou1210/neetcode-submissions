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
    public boolean hasCycle(ListNode head) {
        ListNode pre = head, cur = head;
        while(cur!=null&&cur.next!=null){
            pre = pre.next;
            cur = cur.next.next;
            if(cur == pre){
                return true;
            }
        }
        return false;
    }
}
