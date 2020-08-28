package com.nowcoder.leetcode.dataStructure.unionFind;

/**
 * Created by wangzhiwen on 2020/2/21.
 */
public class L130_被围绕的区域 {
    int rows, cols;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || j == 0 || i == rows - 1 || j == cols - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '#';
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < rows && y >= 0 && y < cols  && board[x][y] == 'O') {
                dfs(board, x, y);
            }
        }
    }

    //并查集
    public void solve1(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int rows = board.length,cols = board[0].length;
        UnionFind u = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if ((i == 0 || j == 0 || i == rows - 1 || j == cols - 1)) {
                        u.connect(dummyNode, i * cols + j);
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O') {
                            u.connect(i * cols + j, x * cols + y);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (u.find(i * cols + j) != u.find(dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
