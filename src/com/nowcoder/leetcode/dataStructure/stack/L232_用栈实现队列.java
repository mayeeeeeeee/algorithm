package com.nowcoder.leetcode.dataStructure.stack;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L232_用栈实现队列 {
    /** Initialize your data structure here. */
    private Stack<Integer> pushStack, popStack;
    public L232_用栈实现队列() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
