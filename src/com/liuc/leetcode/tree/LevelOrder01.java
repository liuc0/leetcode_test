package com.liuc.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  leetcode no.102. 二叉树的层次遍历
 *  给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  例如:
 *  给定二叉树: [3,9,20,null,null,15,7],
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *  返回其层次遍历结果：
 *  [
 *    [3],
 *    [9,20],
 *    [15,7]
 *  ]
 */
public class LevelOrder01 {
    // 记录遍历结果
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;
        levelOrder(root,0);
        return result;
    }
    public void levelOrder(TreeNode root,Integer level){
        // 如果当前结果的个数等于级别数，则需要创建新的数组记录
        if (result.size() == level) result.add(new ArrayList<Integer>());
        // 将当前的值传入数组中
        result.get(level).add(root.val);
        // 如果左节点有值，继续遍历
        if(root.left != null) levelOrder(root.left,level+1);
        // 如果右节点有值，继续遍历
        if(root.right != null) levelOrder(root.right,level+1);
    }
}
