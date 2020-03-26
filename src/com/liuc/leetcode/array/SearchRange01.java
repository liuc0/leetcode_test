package com.liuc.leetcode.array;

/**
 * leetcode no.34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange01 {
    // 解法一：暴力破解法
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        // 先找出最开始出现的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        // 如果第一次遍历没有找到目标值，则表示没有
        if (targetRange[0] == -1) {
            return targetRange;
        }
        // 再找出最后一次出现的位置
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] result  = new SearchRange01().searchRange(nums,8);
        System.out.println();
    }
}

