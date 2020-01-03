package com.liuc.leetcode.array;


/**
 * leetcode 31
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找出逆序
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //交换值
        if (i >= 0) {
            for (int j = nums.length - 1; j > 0; j--) {
                int index = nums[i];
                if (index < nums[j]) {
                    nums[i] = nums[j];
                    nums[j] = index;
                    break;
                }
            }
        }
        //逆序空间反转
        i = i + 1;
        for (int j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 5, 3};
        new NextPermutation().nextPermutation(nums);
        System.out.println();
    }

}
