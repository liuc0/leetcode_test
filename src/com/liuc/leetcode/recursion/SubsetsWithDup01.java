package com.liuc.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode no.90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * 解法一：递归-回溯算法
 */
public class SubsetsWithDup01 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 记录结果
        List<List<Integer>> result = new ArrayList<>();
        // 将数组进行排序
        Arrays.sort(nums);
        // 递归体
        subsetsWithDup(nums, 0, new ArrayList<Integer>(), result);
        // 返回结果
        return result;
    }

    /**
     * @param nums   目标数组
     * @param i      当前索引值
     * @param curr   当前的数组值
     * @param result 返还结果
     */
    private void subsetsWithDup(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        // 每次经过将当前数组值记录下来
        result.add(new ArrayList<Integer>(curr));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            curr.add(nums[j]);
            // 进入递归，将当前值可能出现的情况记录下来
            subsetsWithDup(nums, j + 1, curr, result);
            // 如果索引值超过数组长度，则回溯当前结果
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new SubsetsWithDup01().subsetsWithDup(nums));
    }
}
