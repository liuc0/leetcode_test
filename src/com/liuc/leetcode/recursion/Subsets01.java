package com.liuc.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;
/**
 * leetcode no.78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 解法一：递归-回溯算法
 */
public class Subsets01 {
        public List<List<Integer>> subsets(int[] nums) {
            // 记录结果
            List<List<Integer>> result = new ArrayList<>();
            // 递归体
            subsets(nums,0,new ArrayList<Integer>(),result);
            // 返回结果
            return result;
        }

    /**
     *
     * @param nums 目标数组
     * @param i 当前索引值
     * @param curr 当前的数组值
     * @param result 返还结果
     */
        private void subsets(int[] nums, int i,List<Integer> curr,List<List<Integer>> result) {
            // 每次经过将当前数组值记录下来
            result.add(new ArrayList<Integer>(curr));
            for (int j = i;j<nums.length;j++){
                curr.add(nums[j]);
                // 进入递归，将当前值可能出现的情况记录下来
                subsets(nums,j+1,curr,result);
                // 如果索引值超过数组长度，则回溯当前结果
                curr.remove(curr.size() - 1);
            }
        }

        public static void main(String[] args) {
            int[] nums = {1,2,3};
            System.out.println(new Subsets01().subsets(nums));
        }
}
