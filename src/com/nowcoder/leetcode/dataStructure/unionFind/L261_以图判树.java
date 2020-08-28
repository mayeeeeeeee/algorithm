package com.nowcoder.leetcode.dataStructure.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangzhiwen on 2020/2/9.
 * Graph Valid Tree LintCode178
 *1.判断edges数目必须等于n-1 2.连通图总集合数为1。这样就保证了图中所有点连通且无环。
 */

public class L261_以图判树 {
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(n<=0 || edges==null) {
            return false;
        }
        if(edges.length != n-1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            int num1 = edge[0];
            int num2 = edge[1];
            uf.connect(num1, num2);
        }
        return uf.getCount()==1;
    }
}
