class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 第一步：使用快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 慢指针走一步
            fast = fast.next.next;    // 快指针走两步
        }

        // 第二步：从 slow 之后开始反转链表
        ListNode second = slow.next;
        slow.next = null;             // 断开前半部分和后半部分

        // 反转链表：标准做法
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;  // 暂存下一个节点
            second.next = prev;          // 当前节点指向前一个
            prev = second;               // 移动前指针
            second = tmp;                // 向后走一步
        }

        // prev 就是反转后的链表头
        ListNode first = head;
        second = prev;

        // 第三步：合并两个链表
        while (second != null) {
            ListNode tmp1 = first.next;   // 记录原来的 next
            ListNode tmp2 = second.next;

            first.next = second;          // 插入 second 节点
            second.next = tmp1;           // second 之后连回原来的链表
            first = tmp1;                 // 移动到下一个节点
            second = tmp2;                // 移动 second
        }
    }
}
