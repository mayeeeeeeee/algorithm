package com.nowcoder.leetcode.dataStructure.unionFind;

/**
 * Created by wangzhiwen on 2020/2/21.
 */
public class L547_朋友圈 {
    public int findCircleNum(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int rows = nums.length, cols = nums[0].length;
        UnionFind u = new UnionFind(rows);
        u.setCount(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (nums[i][j] == 1) {
                    u.connect(i, j);
                }
            }
        }
        return u.getCount();
    }
}
