package com.nowcoder.sort;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/6/5.
 * 荷兰国旗问题
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class test {
    public static void main(String[] args) {
        System.out.println();
    }
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length; //0、1、2边界位置
        while (one < two) {
            if (nums[one] == 0) {//如果该位置是0
                swap(nums, ++zero, one++);//交换0、1位置
            } else if (nums[one] == 2) {//是2
                swap(nums, --two, one);
            } else {//是1
                ++one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}