package com.liuc.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode no.22
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis01 {
    private static List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        _recursion(0,0,n,"");
        return result;
    }

    private void _recursion(int left, int right, int n,String curr) {
        if (curr.length() == n*2){
            result.add(curr);
            return;
        }
        if (left<n) _recursion(left+1,right,n,curr+"(");
        if (right < left ) _recursion(left,right+1,n,curr+")");
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParenthesis01().generateParenthesis(3);
        System.out.println("括号的集合为："+result.toString());
    }
}
