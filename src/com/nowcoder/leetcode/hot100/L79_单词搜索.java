package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/16.
 */
public class L79_单词搜索 {
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.length() == 0) {
            return false;
        }
        boolean[][] flags = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, flags, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] flags, int i, int j, int index) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        flags[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !flags[x][y] && dfs(board, word, flags, x, y, index + 1)) {
                return true;
            }
        }
        flags[i][j] = false;
        return false;
    }
}
