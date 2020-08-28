package com.nowcoder.leetcode.dataStructure.unionFind;

/**
 * Created by wangzhiwen on 2020/2/20.
 */
public class test {
    public static void main(String[] args) {
        char[][] a = {{'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};
        new test().solve(a);
    }
    int rows, cols;
    public void solve(char[][] board) {
       rows = board.length;
       cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1 || board[i][j] == 'O') {
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
                    board[i][j] = 'X';
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
}
