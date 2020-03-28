package com.liuc.leetcode.array;

/**
 * leetcode.no.55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class CanJump02 {
    // 回溯算法
    public boolean canJump(int[] nums) {
        return canJump(0,nums);
    }

    private boolean canJump(int index, int[] nums) {
        // 如果当前的索引值与nums长度相等，在走完步数
        if (index == nums.length-1) return true;
        // 当前还差的部署
        int currJump = Math.min(index + nums[index], nums.length - 1);
        for (int i = currJump;i>index;i--) {
            if (canJump(i,nums)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new CanJump02().canJump(nums));
    }
}
