package com.liuc.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode no.46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [[1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]]
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 用来记录节点，防止重复
        int[] visited = new int[nums.length];
        permute(new ArrayList<Integer>(), result, nums,visited);
        return result;
    }
    private void permute(ArrayList<Integer> curr, List<List<Integer>> result, int[] nums,int[] visited) {
        // 回溯结束体
        if (curr.size() ==  nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            curr.add(nums[i]);
            permute(curr,result,nums,visited);
            visited[i] = 0;
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        new Permute().permute(new int[]{1,2,3});
        System.out.println();
    }
}
