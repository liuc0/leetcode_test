package com.liuc.leetcode.recursion;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 */
public class NumWays {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2;i<n;i++){
            result[i] = (result[i-1] +result[i-2]) % 1000000007;
        }
        return result[n-1];
    }

    public static void main(String[] args) {
        int result = new NumWays().numWays(3);
        System.out.println();
    }
}
