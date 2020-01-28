package com.liuc.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class TwoNumSum {

    public static int[] twoSum(int[] nums, int target) {
        //方法一：暴力法
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (target == nums[i]+nums[j]){
                    return new int[] { i, j };
                }
            }
        }
        //方法二：两遍哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complete = target - nums[i];
            if (map.containsKey(complete)){
                return new int[] {map.get(complete),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] test = {3,2,4,2,1,3};
        int[] result =  twoSum(test,4);
    }


}
