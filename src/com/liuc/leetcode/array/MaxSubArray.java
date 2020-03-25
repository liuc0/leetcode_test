package com.liuc.leetcode.array;

/**
 * leetcode no.53 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // 获取当前的总和
        int currSum = nums[0];
        // 获取最大总和
        int maxSum = nums[0];
        for (int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i],currSum+nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
