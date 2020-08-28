package com.nowcoder.leetcode.hot100;

import java.util.*;

/**
 * Created by wangzhiwen on 2020/1/26.
 */
public class L1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int find=target-nums[i];
            if(map.containsKey(find)){
                return new int[]{i,map.get(find)};
            }
            else {
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
