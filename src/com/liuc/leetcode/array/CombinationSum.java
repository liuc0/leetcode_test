package com.liuc.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode no.39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {
    // 解法一：回溯算法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result,candidates, target, new ArrayList<Integer>(),0);
        return result;
    }

    private void combinationSum( List<List<Integer>> result,int[] candidates, int target, List<Integer> currList,int index) {
        // 结束条件
        if (target == 0) result.add(new ArrayList<>(currList));
        // 回溯体
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            currList.add(candidates[i]);
            combinationSum(result,candidates, target - candidates[i], currList,i);
            // 回溯到最后减去最后值，继续遍历
            currList.remove(currList.size() -1);
        }
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println();
    }

}
