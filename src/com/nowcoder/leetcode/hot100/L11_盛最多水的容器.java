package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/6.
 */
public class L11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
