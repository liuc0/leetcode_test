package com.liuc.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode no.94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。

 |  示例:
 |
 |  输入: [1,null,2,3]
 |          1
 |           \
 |            2
 |          /
 |         3
 * 输出: [1,3,2]
 * 解法一：使用递归的方式
 */
public class InorderTraversal01 {
    public static List<Integer> inorder(TreeNode root) {
        // 创建一个list记录
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null) inorder(root.left);
            list.add(root.val);
            if (root.right != null) inorder(root.right);
        }
        return list;
    }
}
