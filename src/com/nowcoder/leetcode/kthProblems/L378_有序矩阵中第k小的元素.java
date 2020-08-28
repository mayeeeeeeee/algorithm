package com.nowcoder.leetcode.kthProblems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/7.
 */
public class L378_有序矩阵中第k小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        int rows = matrix.length, cols = matrix[0].length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (Integer.valueOf(matrix[a / cols][a % cols]).compareTo(matrix[b / cols][b % cols])));
        heap.offer(0);
        int cur = 0;
        for (int i = 1; i <= k; i++) {
            cur = heap.poll();
            int row = cur / cols, col = cur & cols;
            if (row + 1 < rows) {
                heap.offer(matrix[row + 1][col]);
            }
            if (col + 1 < cols) {
                heap.offer(matrix[row][col + 1]);
            }
        }
        return cur;
    }
}
