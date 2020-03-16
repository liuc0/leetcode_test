package com.liuc.leetcode.recursion;


/**
 * leetcode no.70 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs01 {

    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        return _recursion(0, n, result);
    }

    /**
     * 递归体
     * @param i 实际台阶
     * @param n 楼顶台阶
     * @param result
     * @return
     */
    private int _recursion(int i, int n, int[] result) {
        if (i>n) return 0;
        if (n == i) return 1;
        if (result[i] > 0) return result[i];
        return _recursion(i+1,n,result)+_recursion(i+2,n,result);
    }

    public static void main(String[] args) {
        int result = new ClimbStairs01().climbStairs(4);
        System.out.println("结果为"+result+"种");
    }
}
