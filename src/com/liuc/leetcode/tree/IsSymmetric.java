package com.liuc.leetcode.tree;

/**
 * leetcode no.101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 先判断两个节点是否都为空，如果都为空则递归完子节点且都相等
        if (left == null && right == null) return true;
        // 如果还没递归完出现不一致，则二叉树不队称
        if (left == null || right == null) return false;
        // 当层树的左右节点如果相当，则继续递归，否则不队称
/*        if (left.val == right.val){
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
        return false;*/
        return left.val == right.val && isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right);
    }
}
