package com.nowcoder.leetcode;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/10/13.
 * 一定会找到则不需要boolean返回，可能失败需要boolean
 * 有顺序的不需要存boolean[]状态 但要用i表示顺序递归
 * 无序需要存状态，每次从0～n-1迭代找到状态满足的元素
 */
public class test{
    public static void main(String[] args) {
        Queue<Integer> heap = new PriorityQueue<>((b, a) -> (a.compareTo(b)));
    }
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> (matrix[a / cols][a % cols] - matrix[b / cols][b % cols]));
        heap.offer(0);
        boolean[][] flag = new boolean[rows][cols];
        int res = 0;
        flag[0][0] = true;
        for (int i = 0; i < k; i++) {
            int poll = heap.poll();
            int x = poll / cols, y = poll % cols;
            res = matrix[x][y];
            if (x + 1 < rows && !flag[x + 1][y]) {
                flag[x + 1][y] = true;
                heap.offer(poll + cols);
            }
            if (y + 1 < cols && !flag[x][y + 1]) {
                flag[x][y + 1] = true;
                heap.offer(x * cols + y + 1);
            }
            // System.out.println(x + " " + y + " " + res);
        }
        return res;
    }

}
