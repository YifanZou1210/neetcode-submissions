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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list1 = head, list2 = slow.next;
        slow.next = null;
        ListNode pre = null, cur = list2;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        list2 = pre;
        while(list2!=null){
            ListNode tmp1 = list1.next;
            ListNode tmp2 = list2.next;
            list1.next = list2;
            list2.next = tmp1;
            list1 = tmp1;
            list2 = tmp2;
        }
    }
}
