package com.liuc.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[0][]);
        }
        // 将二维数据进行排序处理
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
/*        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        for (int i = 0; i < intervals.length; i++) {
            if (result.isEmpty() || result.getLast()[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2,8,15},{3,6,10,18}};
        int[][] result = new Merge().merge(intervals);
        System.out.println(result);
    }
}
