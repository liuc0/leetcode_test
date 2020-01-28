package com.liuc.leetcode.link;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 *      输入:
 *      [
 *        1->4->5,
 *        1->3->4,
 *        2->6
 *      ]
 *      输出: 1->1->2->3->4->4->5->6

 */
public class MergeKLists {
    /**
     * 利用分治算法
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)
            return null;
        // 数组中只有一个则合并成功
        if(lists.length == 1)
            return lists[0];
        // 数组还剩两个，则继续合并
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        // 将当前数组分成部分
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }
        // 递归mergeKLists是继续分开，最后再调用mergeTwoLists合并
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));

    }

    /**
     * 将数组进行合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        // 对比两个节点的大小
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
}
