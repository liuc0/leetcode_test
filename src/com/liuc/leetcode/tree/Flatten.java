package com.liuc.leetcode.tree;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        // 记录右节点
        TreeNode temp = root.right;
        root.right = root.left;
        // 将左节点替换
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = temp;
    }
}
