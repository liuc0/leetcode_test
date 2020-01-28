package com.liuc.leetcode.link;

public class HasCycle {

    // 双指针方式
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 设置双指针
        ListNode first = head;
        ListNode second = head.next;
        while (first != second) {
            if (second == null || second.next == null) {
                return false;
            }
            first = first.next;
            second = second.next.next;
        }
        return true;
    }

}
