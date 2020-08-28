package com.nowcoder.leetcode.dfsSearch;

/**
 * Created by wangzhiwen on 2019/10/23.
 */
public class L79_单词搜索 {
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        rows = board.length;
        cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word.toCharArray(), visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, boolean[][] visited, int index, int i, int j) {
        if (index == word.length) return true;
        if (i < 0 || i == rows || j < 0 || j == cols || visited[i][j] || board[i][j] != word[index]) {
            return false;
        }
        visited[i][j] = true;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (dfs(board, word, visited, index + 1, x, y)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
