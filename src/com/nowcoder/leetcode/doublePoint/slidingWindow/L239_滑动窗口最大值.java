package com.nowcoder.leetcode.doublePoint.slidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/7.
 */
public class L239_滑动窗口最大值 {
    //使用堆
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 3) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k  + 1];
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> (a > b ? a : b));
        int i;
        for (i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = nums[i];
                heap.remove(nums[i - k + 1]);
            }
        }
        return res;
    }
    //好方法
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] maxes = new int[nums.length - k + 1];

        int i, j;
        int maxPos = -1;

        for (i = 0; i <= nums.length - k; ++i) {
            // Ending index of the current window
            j = i + k - 1;

            // new element >= max of last window
            // that means new element is max in the two windows
            // here using >= to make maxPos stay in the windows for a longer time
            if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                maxPos = j;
                maxes[i] = nums[maxPos];
            }
            // new element < max of last window
            // AND the max of last window is also in this window
            // => it means the max of the last window is still the max of this window
            else if (i <= maxPos) {
                maxes[i] = nums[maxPos];
            }
            // new element < max of last window
            // AND the max of last window is not in this window
            // So we do not know which element is the max in this window, we have to scan the window to find it
            else {
                int maxWindow = Integer.MIN_VALUE;
                int maxPosWindow = 0;
                for (int z = i; z <= j; ++z) {
                    if (nums[z] > maxWindow) {
                        maxPosWindow = z;
                        maxWindow = nums[z];
                    }
                }
                maxPos = maxPosWindow;
                maxes[i] = nums[maxPos];
            }
        }
        return maxes;
    }
}
