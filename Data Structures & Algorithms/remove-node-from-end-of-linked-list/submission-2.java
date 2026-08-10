class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建 dummy 节点，避免删除 head 时出错
        ListNode dummy = new ListNode(0, head);

        // 第一步：快指针先走 n+1 步，确保慢指针停在目标节点前一个
        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 第二步：快慢指针同时前进
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 第三步：删除目标节点（slow.next 是要删除的）
        slow.next = slow.next.next;

        // 返回新链表的头结点
        return dummy.next;
    }
}
