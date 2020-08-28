package com.nowcoder.leetcode.kthProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/19.
 */
public class L373_查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        heap.offer(new int[]{0, 0});
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] flag = new boolean[nums1.length][nums2.length];
        res.add(new ArrayList<Integer>(){{add(nums1[0]);
            add(nums2[0]);}});
        for (int i = 0; i < k; i++) {
            int[] poll = heap.poll();
            int i1 = poll[0], i2 = poll[1];
            res.add(new ArrayList<Integer>(){{add(nums1[i1]);
                add(nums2[i2]);}});
            if (i1 + 1 < nums1.length && !flag[i1 + 1][i2]) {
                flag[i1 + 1][i2] = true;
                heap.offer(new int[]{i1 + 1, i2});
            }
            if (i2 + 1 < nums2.length && !flag[i1][i2 + 1]) {
                flag[i1][i2 + 1] = true;
                heap.offer(new int[]{i1, i2 + 1});
            }
        }
        return res;
    }
}
