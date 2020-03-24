package com.liuc.leetcode.linked;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建虚拟头结点
        ListNode currhead = new ListNode(0);
        // 创建当前节点合并链表
        ListNode curr = currhead;
        // 迭代链表，判断两值大小
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 将最后不为空的节点放入链表中
        curr.next = l1 == null ? l2 : l1;
        return currhead.next;
    }
}
