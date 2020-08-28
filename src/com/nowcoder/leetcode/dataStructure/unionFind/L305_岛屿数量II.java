package com.nowcoder.leetcode.dataStructure.unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiwen on 2020/2/9.
 */
public class L305_岛屿数量II {
    public List<Integer> numIslands2(int m, int n, Point[] operators) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return res;
        }
        UnionFind u = new UnionFind(n * m);
        int[][] nums = new int[m][n];
        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x, y = operators[i].y;
            if (nums[x][y] == 1) {
                res.add(u.getCount());
                continue;
            }
            nums[x][y] = 1;
            u.setCount(u.getCount() + 1);
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[j], yy = y + dy[j];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && nums[xx][yy] == 1) {
                    u.connect(x * n + y, xx * n + yy);
                }
            }
            res.add(u.getCount());
        }
        return res;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
