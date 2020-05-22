package com.liuc.leetcode.array;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 */
public class FindNumberIn2DArray01 {
    // 从右上角开始走，利用这个顺序关系可以在O(m+n)的复杂度下解决这个题
    // 如果当前位置元素比target小，则row++
    // 如果当前位置元素比target大，则col--
    // 如果相等，返回true
    // 如果越界了还没找到，说明不存在，返回false
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while(row < m && col >= 0) {
            if(matrix[row][col] > target){
                col --;
            }else if (matrix[row][col] < target){
                row ++;
            }else {
                return true;
            }
        }
        return false;
    }
}
