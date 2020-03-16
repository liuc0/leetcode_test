package com.liuc.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 * 解法二：使用栈的方式
 */
public class InorderTraversal02 {

    public List<Integer> inorder(TreeNode root) {
        // 创建一个list做记录
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        // 使用栈来确定树的左右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            // 如果当前节点不为空，则将当前节点入栈
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            // 删除栈中最后一个数据，并返回当前最后的栈底
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
