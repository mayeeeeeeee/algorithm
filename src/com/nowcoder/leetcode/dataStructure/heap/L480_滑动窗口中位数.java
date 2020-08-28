package com.nowcoder.leetcode.dataStructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L480_滑动窗口中位数 {
    private double median;
    private Queue<Integer> minQueue = new PriorityQueue<>(), maxQueue = new PriorityQueue<>((a, b) -> (b.compareTo(a)));

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            return new double[0];
        }
        double[] medians = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        medians[0] = median;
        for (int i = k; i < nums.length; i++) {
            addNum(nums[i]);
            removeNum(nums[i - k]);
            medians[i - k + 1] = median;
        }
        return medians;
    }

    public void addNum(int num) {
        Queue<Integer> add = minQueue, last = maxQueue;
        if (num < median) {
            add = maxQueue;
            last = minQueue;
        }
        add.offer(num);
        adjust(add, last);
    }
    public void removeNum(int num){
        Queue<Integer> remove = minQueue, last = maxQueue;
        if (!maxQueue.isEmpty() && num <= maxQueue.peek()) {
            remove = maxQueue;
            last = minQueue;
        }
        remove.remove(num);
        adjust(last, remove);
    }
    public void adjust(Queue<Integer> more, Queue<Integer> less) {
        int diff = more.size() - less.size();
        if (diff == 0) {
            median = ((double)more.peek() + less.peek()) / 2;
        }
        else if (diff == 1) {
            median = more.peek();
        }
        else if (diff == 2) {
            less.offer(more.poll());
            median = ((double)more.peek() + less.peek()) / 2;
        }
    }
}
