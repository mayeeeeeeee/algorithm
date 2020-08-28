package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/5.
 */
/*
state      : f(i)表示前i个元素最短无序连续子数组长度
function   :
initialize :
answer     :
*/
public class L581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        for (; i < nums.length - 1 && nums[i] <= nums[i + 1]; i++) {}
        for (; j >= 1 && nums[j] >= nums[j - 1]; j--){}
        if (j < i) {
            return 0;
        }
        int max = nums[i], min = nums[j];
        for (int k = i; k <= j; k++) {
            if (nums[k] > max) {
                max = nums[k];
            }
            if (nums[k] < min) {
                min = nums[k];
            }
        }
        int first = 0, last = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > min) {
                first = k;
                break;
            }
        }
        for (int k = nums.length - 1; k >= 0 ; k--) {
            if (nums[k] < max) {
                last = k;
                break;
            }
        }
        return last - first + 1;
    }
}
