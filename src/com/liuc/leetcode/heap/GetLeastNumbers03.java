package com.liuc.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class GetLeastNumbers03 {
    // 解法三：堆排序，利用堆的特性，这里是使用了Java维护的一个堆
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        // 返回堆中的元素
        int[] res = new int[queue.size()];
        int idx = 0;
        for (int num : queue) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        System.out.println(new GetLeastNumbers03().getLeastNumbers(arr, 2).toString());
    }
}
