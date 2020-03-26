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
public class SearchRange02 {
    // 解法二：二分查找法
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = searchRange(nums, target, true);
        int end = searchRange(nums, target, false);
        if (start == nums.length || nums[start] != target) {
            return result;
        }
        result[0] = start;
        result[1] = end-1;
        return result;
    }

    private int searchRange(int[] nums, int target, boolean b) {
        int result = 0;
        int len = nums.length;
        while (result < len) {
            int mid = (result + len) / 2;
            if (nums[mid] > target || (b && target == nums[mid])) {
                len = mid;
            } else {
                result = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 7, 10};
        int[] result = new SearchRange02().searchRange(nums, 7);
        System.out.println();
    }
}

