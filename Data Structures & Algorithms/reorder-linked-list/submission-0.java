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
        //1.找中点
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur1 = head, list2 = slow.next;
        slow.next = null;//断开前后两部分
        ListNode pre = null, cur = list2;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ListNode cur2 = pre;
        while(cur2!=null){
            ListNode tmp1 = cur1.next;
            cur1.next = cur2;
            ListNode tmp2 = cur2.next;
            cur2.next = tmp1;
            cur1 = tmp1;
            cur2 = tmp2;
        }
    }
}
