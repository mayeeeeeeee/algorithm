package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        // System.out.println(l);
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = l;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (nums[mid] <= target) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        res[1] = l;
        return res;
    }
}
