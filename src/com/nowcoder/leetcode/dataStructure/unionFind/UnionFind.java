package com.nowcoder.leetcode.dataStructure.unionFind;

/**
 * Created by wangzhiwen on 2020/2/9.
 */
public class UnionFind {
    private int[] father;
    private int count;
    public UnionFind (int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void connect(int x, int y) {
        int rootx = find(x), rooty = find(y);
        if (rootx != rooty) {
            father[rootx] = rooty;
            count--;
        }
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}