package com.nowcoder.leetcode.doublePoint.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhiwen on 2020/2/18.
 */
public class L992_k个不同整数的子数组 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int l = 0, r = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            r++;
            while (map.size() > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            int temp = l;
            while (map.size() == k) {
                res++;
                map.put(nums[temp], map.getOrDefault(nums[temp], 0) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                temp++;
            }
            temp--;
            while (temp >= l) {
                map.put(nums[temp], map.getOrDefault(nums[temp], 0) + 1);
                temp--;
            }
        }
        return res;
    }
}
