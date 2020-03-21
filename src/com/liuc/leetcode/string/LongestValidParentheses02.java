package com.liuc.leetcode.string;

import java.util.Stack;

/**
 * leetcode no.32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses02 {
    // 解法二：使用栈结构方式
    public int longestValidParentheses(String s) {
        int result = 0;
        // 建立一个栈
        Stack<Integer> stack = new Stack<>();
        // 设立一个虚拟头指针
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(new LongestValidParentheses02().longestValidParentheses(s));
    }
}
