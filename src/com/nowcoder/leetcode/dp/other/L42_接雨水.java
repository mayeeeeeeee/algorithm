package com.nowcoder.leetcode.dp.other;

/**
 * Created by wangzhiwen on 2020/2/10.
 */
public class L42_接雨水 {
    //方法一：dp
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length, sum = 0;
        int[] left = new int[len], right = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            int temp = Math.min(left[i], right[i]);
            sum += Math.max(0, temp - height[i]);
        }
        return sum;
    }
    //方法二：双指针
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0, l = 0, r = height.length - 1, curMax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                curMax = height[l];
                l++;
                while (l < r && height[l] <= curMax) {
                    sum += curMax - height[l++];
                }
            }
            else {
                curMax = height[r];
                r--;
                while (l < r && height[r] <= curMax) {
                    sum += curMax - height[r--];
                }
            }
        }
        return sum;
    }
}
