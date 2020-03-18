package com.liuc.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  leetcode no.515. 在每个树行中找最大值
 *  您需要在二叉树的每一行中找到最大的值。
 *
 *  示例：
 *
 *  输入:
 *            1
 *           / \
 *          3   2
 *         / \   \
 *        5   3   9
 *
 *  输出: [1, 3, 9]
 */
public class LargestValues01 {
    public List<Integer> largestValues(TreeNode root) {
        // 记录结果
        List<Integer> result = new ArrayList<>();
        // 进入递归方法
        largestValues(root,result,0);
        return result;
    }
    private void largestValues(TreeNode root,List<Integer> result, int level) {
        // 递归终止条件
        if (root == null) return;
        // 结果数与层次数相等边将结果存入
        if (result.size() == level)  result.add(level,root.val);
        // 比较同层次中节点大小
        result.set(level,Math.max(result.get(level),root.val));
        // 向左下节点递归
        if (root.left != null) largestValues(root.left,result,level+1);
        // 向右下节点递归
        if (root.right != null) largestValues(root.right,result,level+1);
    }
}
