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
public class LongestValidParentheses01 {
    // 解法一：通过计数器方式
    public int longestValidParentheses(String s) {
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
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(new LongestValidParentheses01().longestValidParentheses(s));
    }
}
