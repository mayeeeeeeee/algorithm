package com.nowcoder.leetcode.dataStructure.stack;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L84_柱状图中最大的矩形 {
    //动态规划，滚动数组优化，否则爆内存
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length, max = 0;
        int[][] min = new int[1][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    min[0][j] = heights[i];
                }
                else {
                    min[0][j] = Math.min(min[0][j],heights[i]);
                }
                max = Math.max(max, min[0][j] * (j - i + 1));
            }
        }
        return max;
    }
    //单调栈
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = stack.pop(), l;
                if (!stack.isEmpty()) {
                    l = stack.peek();
                }
                else {
                    l = -1;
                }
                max = Math.max(max, (i - 1 - l) * heights[h]);
                // System.out.println((l + 1) + " " + i + " " + heights[h]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()], l;
            if (stack.isEmpty()) {
                l = - 1;
            }
            else {
                l = stack.peek();
            }
            max = Math.max(max, (heights.length - 1 - l) * h);
            // System.out.println((l + 1) + " " + heights.length + " " + h);
        }
        return max;
    }

    //简化版代码
    public int largestRectangleArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();  //维护单调递增
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {    //如果栈顶高度大于当前高度
                int h = height[stack.pop()];		//保存栈顶元素信息
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;		//如果栈已经为空，宽度为i，否则i-s.top()-1
                max = Math.max(max, h * w);
            }
            stack.push(i);				//压入栈中
        }

        return max;
    }
}
