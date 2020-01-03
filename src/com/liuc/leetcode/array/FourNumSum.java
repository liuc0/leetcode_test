package com.liuc.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 18
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [[-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]]
 */
public class FourNumSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        //如果数组为空，则直接返回结果
        if (nums.length == 0) {
            return resultList;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            //去重处理
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                //去重处理
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                //定义两个指针
                int l = j + 1;
                int r = nums.length-1;
                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    //分别移动两个指针
                    if (sum < target){
                        l++;
                    }else if (sum > target){
                        r--;
                    }else{
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        resultList.add(list);
                        //进行去重
                        while (l < r-1 && nums[l] == nums[l+1]){
                            l++;
                        }
                        while (r < nums.length-1 && nums[r] == nums[r+1]){
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = new FourNumSum().fourSum(nums, target);
        System.out.println(result);
    }
}
