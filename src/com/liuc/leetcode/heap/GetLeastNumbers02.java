package com.liuc.leetcode.heap;

import java.util.Arrays;

/**
 * leetcode 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class GetLeastNumbers02 {
    // 解法二：堆排序，利用堆的特性,自建一个堆排序
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        for (int i = arr.length; i > 0; i--) {
            int parentIdx = i / 2;      //父节点
            for(; parentIdx >= 0; parentIdx--){
                if(parentIdx * 2 >= i){
                    continue;
                }
                int left = parentIdx * 2;       //左子节点位置
                int right = (left + 1) >= i ? left : (left + 1);    //右子节点位置，如果没有右节点，默认为左节点位置
                int maxChildId = arr[left] >= arr[right] ? left : right;
                if(arr[maxChildId] > arr[parentIdx]){   //交换父节点与左右子节点中的最大值
                    int temp = arr[parentIdx];
                    arr[parentIdx] = arr[maxChildId];
                    arr[maxChildId] = temp;
                }
            }
            int temp = arr[0];      //堆顶元素(第一个元素)与Kn交换
            arr[0] = arr[i-1];
            arr[i-1] = temp;
        }
        for (int j = 0; j < k;j++){
            result[j] = arr[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new GetLeastNumbers02().getLeastNumbers(arr,2).toString());
    }
}
