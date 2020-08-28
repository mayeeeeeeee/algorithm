package com.nowcoder.leetcode.dataStructure.unionFind;

/**
 * Created by wangzhiwen on 2020/2/21.
 */
public class L684_冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind u = new UnionFind(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0] - 1, y = edges[i][1] - 1;
            if (u.find(x) == u.find(y)) {
                return new int[]{x + 1, y + 1};
            }
            else {
                u.connect(x, y);
            }
        }
        return new int[0];
    }
}
