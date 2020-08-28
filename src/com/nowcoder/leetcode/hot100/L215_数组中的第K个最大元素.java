package com.nowcoder.leetcode.hot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/26.
 */
public class L215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (i >= k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
