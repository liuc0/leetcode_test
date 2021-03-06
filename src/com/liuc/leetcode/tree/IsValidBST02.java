package com.liuc.leetcode.tree;

/**
 * leetcode no.98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *   1。节点的左子树只包含小于当前节点的数。
 *   2.节点的右子树只包含大于当前节点的数。
 *   3.所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *   输入:
 *        2
 *       / \
 *      1   3
 *      输出: true
 * 示例 2:
 *   输入:
 *       5
 *      / \
 *     1   4
 *        / \
 *       3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST02 {
    private long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left) && prev < (prev = root.val) && isValidBST(root.right);
    }
}
