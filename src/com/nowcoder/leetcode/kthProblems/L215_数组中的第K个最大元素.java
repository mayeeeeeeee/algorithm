package com.nowcoder.leetcode.kthProblems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/19.
 */
public class L215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if (i >= k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
