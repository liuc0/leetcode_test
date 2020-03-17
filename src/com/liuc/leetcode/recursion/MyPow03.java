package com.liuc.leetcode.recursion;

/**
 *  leetcode no.50. Pow(x, n)
 *  实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 *  示例 1:
 *
 *  输入: 2.00000, 10
 *  输出: 1024.00000
 *  示例 2:
 *
 *  输入: 2.10000, 3
 *  输出: 9.26100
 *  示例 3:
 *
 *  输入: 2.00000, -2
 *  输出: 0.25000
 *  解释: 2-2 = 1/22 = 1/4 = 0.25
 *  说明:
 *
 *  -100.0 < x < 100.0
 *  n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *  方法三：分治算法（写法不同）
 */

public class MyPow03 {
    public double myPow(double x, int n) {
        long ln = n;
        if(n<0) {
            x = 1 / x;
            ln = -n;
        }
        return myPow(x,ln);
    }
    public double myPow(double x, long n) {
        if (n == 0) return 1;
        if (n%2 == 0) return myPow(x*x,n/2);
        else return x*myPow(x*x,n/2);
    }
    public static void main(String[] args) {
        System.out.println(new MyPow03().myPow(2,-2147483648));
    }
}
