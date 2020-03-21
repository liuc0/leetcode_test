package com.liuc.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode no.169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement01 {
    // 解法一：先去重，在对比得出出现超过一半的数
    public int majorityElement(int[] nums) {
        // 对数组进行去重
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        for (int s : set) {
            int count = 0;
            for (int num : nums)
                if (s == num) count++;
            if (count > nums.length/2) return s;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,1};
        System.out.println(new MajorityElement01().majorityElement(nums));
    }
}
