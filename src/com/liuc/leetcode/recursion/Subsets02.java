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
 * 解法二：暴力破解
 */
public class Subsets02 {
        public List<List<Integer>> subsets(int[] nums) {
            // 记录结果
            List<List<Integer>> result = new ArrayList<>();
            // 将空数组存入
            result.add(new ArrayList<Integer>());
            for (int i = 0;i<nums.length;i++){
                // 记录每次遍历的结果
                List<List<Integer>> resultByFor = new ArrayList<>();
                //遍历之前的已知道的结果
                for(List<Integer> list : result){
                    List<Integer> curr = new ArrayList<>(list);
                    // 加入当前遍历的数组值放入已知的结果中
                    curr.add(nums[i]);
                    resultByFor.add(curr);
                }
                result.addAll(resultByFor);
            }
            return result;
        }

        public static void main(String[] args) {
            int[] nums = {1,2,3,4};
            System.out.println(new Subsets02().subsets(nums));
        }
}
