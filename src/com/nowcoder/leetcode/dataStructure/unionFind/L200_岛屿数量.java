package com.nowcoder.leetcode.dataStructure.unionFind;

/**
 * Created by wangzhiwen on 2020/2/20.
 */
public class L200_岛屿数量  {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        UnionFind u = new UnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    u.setCount(u.getCount() + 1);
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        u.connect(i * cols + j, (i + 1) * cols + j);
                    }
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        u.connect(i * cols + j, i * cols + j + 1);
                    }
                }
            }
        }
        return u.getCount();
    }
}