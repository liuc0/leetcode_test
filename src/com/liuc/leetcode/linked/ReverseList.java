package com.liuc.leetcode.linked;


/**
 * leetcode no.206 反转链表
 * <p>
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

    // 递归方式
    public ListNode reverseListRecursion(ListNode head) {
        // 设置当前节点
        ListNode curr = head;
        // 当前节点与下一个节点不为空，则进入递归
        if (head != null && head.next != null) {
            curr = reverseList(head.next);
            head.next.next = head;
            head.next = null;
        }
        return curr;
    }

    // 非递归方式
    public ListNode reverseList(ListNode head) {
        // 设置指针节点
        ListNode prev = null;
        // 设置当前节点
        ListNode curr = head;
        // 当前节点不为空
        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
