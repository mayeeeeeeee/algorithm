package com.nowcoder.leetcode.dataStructure.unionFind;

/**
 * Created by wangzhiwen on 2020/2/21.
 */
public class L685_冗余连接II {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] degree = new int[edges.length + 1];
        for (int[] edge : edges) {
            degree[edge[1]]++;
        }
        for (int i = edges.length - 1; i >= 0; i++) {
            if (degree[edges[i][1]] == 2) {
                if (helper(edges, i)) return edges[i];
            }
        }
        for (int i = edges.length - 1; i >= 0; i++) {
            if (helper(edges, i)) return edges[i];
        }
        return new int[0];
    }
    public boolean helper(int[][] edges, int i) {
        UnionFind u = new UnionFind(edges.length + 1);
        u.setCount(edges.length);
        for (int j = 0; j < edges.length; j++) {
            if (i != j) {
                u.connect(edges[j][0], edges[j][1]);
            }
        }
        return u.getCount() == 1;
    }
}
