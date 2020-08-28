package com.nowcoder.leetcode.dataStructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L295_数据流的中位数 {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    double mid;

    public L295_数据流的中位数() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (a.compareTo(b)));
        mid = 0;
    }

    public void addNum(int num) {
        Queue<Integer> add,last;
        if (num < mid) {
            add = maxHeap;
            last = minHeap;
        }
        else {
            add = minHeap;
            last = maxHeap;
        }
        add.offer(num);
        int diff = add.size() - last.size();
        if (diff == 0) {
            mid = (double)(add.peek() + last.peek()) / 2;
        }
        else if (diff == 1) {
            mid = add.peek();
        }
        else if (diff == 2) {
            last.offer(add.poll());
            mid = (double)(add.peek() + last.peek()) / 2;
        }
    }

    public double findMedian() {
        return mid;
    }
}
