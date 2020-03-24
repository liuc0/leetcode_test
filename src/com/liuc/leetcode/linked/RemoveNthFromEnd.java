package com.liuc.leetcode.linked;

/**
 * leetcode no.19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头结点
        ListNode curr = new ListNode(0);
        curr.next = head;
        // 采用双指针的方式
        ListNode start = curr;
        ListNode end = curr;
        // start 节点到n节点处，结束迭代
        while (n != 0) {
            start = start.next;
            n--;
        }
        // 开始迭代start、end节点，当start的next节点为空,刚好为倒数n为数之前
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        // 将节点指向下下节点
        end.next = end.next.next;
        return curr.next;
    }
}
