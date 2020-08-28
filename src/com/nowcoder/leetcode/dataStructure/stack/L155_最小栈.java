package com.nowcoder.leetcode.dataStructure.stack;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L155_最小栈 {
    /** initialize your data structure here. */
    Stack<Integer> data, min;
    public L155_最小栈 () {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int x = data.pop();
        if (x == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
