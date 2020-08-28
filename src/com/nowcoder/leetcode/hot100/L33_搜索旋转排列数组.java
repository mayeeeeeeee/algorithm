package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/10.
 */
public class L33_搜索旋转排列数组 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 0) {
            return -1;
        }
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] < nums[nums.length - 1]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        if (target > nums[nums.length - 1]) {
            l = 0;
            r--;
        }
        else {
            r = nums.length - 1;
        }
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
