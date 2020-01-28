package com.liuc.leetcode.linked;

import java.util.Stack;

/**
 * LeetCode-no.24 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class SwapPairs {

    // 非递归方式
    public ListNode swapPairs(ListNode head) {
        // 增加一个空节点
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode temp = node;
        while (temp.next != null && temp.next.next != null){
            // 创建start，end两个指针，分别为当前节点的后两个节点
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            //改变start和end的指向，于是就变成2->1
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return node.next;
    }

    // 递归方式
    public ListNode swapPairs01(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        //假设链表是 1->2->3->4
        //这句就先保存节点2
        ListNode tmp = head.next;
        //继续递归，处理节点3->4
        //当递归结束返回后，就变成了4->3
        //于是head节点就指向了4，变成1->4->3
        head.next = swapPairs(tmp.next);
        //将2节点指向1
        tmp.next = head;
        return tmp;
    }

    // 利用栈的方式
    public ListNode swapPairs02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //用stack保存每次迭代的两个节点
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        //head指向新的p节点，函数结束时返回head.next即可
        head = p;
        while(cur!=null && cur.next!=null) {
            stack.add(cur);
            stack.add(cur.next);

            cur = cur.next.next;
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        //注意边界条件，当链表长度是奇数时，cur就不为空
        if(cur!=null) {
            p.next = cur;
        } else {
            p.next = null;
        }
        return head.next;
    }
}
