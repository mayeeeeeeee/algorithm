package com.nowcoder.leetcode.dp.other;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/10.
 */
class Cell {
    Integer x, y, h;
    public Cell (Integer x, Integer y, Integer h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}
public class L407_接雨水II {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int rows = heightMap.length, cols = heightMap[0].length, sum = 0;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> heap = new PriorityQueue<>((a, b) -> (a.h.compareTo(b.h)));
        for (int i = 0; i < rows; i++) {
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            heap.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
            visited[i][cols - 1] = true;
        }
        for (int i = 0; i < cols; i++) {
            heap.offer(new Cell(0, i, heightMap[0][i]));
            visited[0][i] = true;
            heap.offer(new Cell(rows - 1, i, heightMap[rows - 1][i]));
            visited[rows - 1][i] = true;
        }
        while (!heap.isEmpty()) {
            Cell poll = heap.poll();
            for (int i = 0; i < 4; i++) {
                int xx = poll.x + dx[i], yy = poll.y + dy[i];
                if (xx >= 0 && xx < rows && yy >= 0 && yy < cols && !visited[xx][yy]) {
                    if (heightMap[xx][yy] < poll.h) {
                        sum += poll.h - heightMap[xx][yy];
                        heap.offer(new Cell(xx, yy, poll.h));
                    }
                    else {
                        heap.offer(new Cell(xx, yy, heightMap[xx][yy]));
                    }
                    visited[xx][yy] = true;
                }
            }
        }
        return sum;
    }
}
