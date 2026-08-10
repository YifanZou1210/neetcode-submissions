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
    public ListNode mergeKLists(ListNode[] lists) {
        //定义最小堆，按节点升序排序
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val-b.val);
        //将listnode放入heap中
        for(ListNode node:lists){
            if(node!=null){
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!heap.isEmpty()){
            ListNode min = heap.poll();
            tail.next = min;
            tail = tail.next;
            if(min.next!=null){
                heap.offer(min.next);
            }
        }
        return dummy.next;
    }
}
