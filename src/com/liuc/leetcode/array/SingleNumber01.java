package com.liuc.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode no.136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber01 {
    // 解法一：利用 Hash 表
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,2);
            } else{
                map.put(num,1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1){
                return integer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int result = new SingleNumber01().singleNumber(nums);
        System.out.println();
    }
}
