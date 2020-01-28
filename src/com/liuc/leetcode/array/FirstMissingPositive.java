package com.liuc.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:

 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive {
    // 解法一：暴力解法
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet();
        // 排序
        Arrays.sort(nums);
        // 去重
        for (int num : nums) {
            if (num>0){
                set.add(num);
            }
        }
        int len = set.size();
        // [1, -1, 3, 4]
        for (int i = 1;i<=len;i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return len+1;
    }
    // 解法二：桶排序
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 满足在指定范围内、并且没有放在正确的位置上，才交换
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    /**
     * 交换方式
     * @param nums  数组
     * @param index1 索引数-1
     * @param index2 索引位置
     */
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
