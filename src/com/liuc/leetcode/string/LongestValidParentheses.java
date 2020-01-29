package com.liuc.leetcode.string;

import java.util.Stack;

/**
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
public class LongestValidParentheses {
    // 解法一：暴力破解法
    public int longestValidParentheses01(String s) {
        // 计算长度
        int len = 0;
        // 每次验证三位数
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    len = Math.max(len, j - i);
                }
            }
        }
        return -1;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    // 解法二：通过计数器方式
    public int longestValidParentheses02(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    count++;
                } else {
                    count--;
                }

                if (count < 0) {
                    break;
                }
                if (count == 0) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                    }
                }
            }
        }
        return max;
    }

    // 解法三：使用栈结构方式
    public int longestValidParentheses03(String s) {
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

}
