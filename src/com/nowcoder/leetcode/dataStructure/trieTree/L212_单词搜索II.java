package com.nowcoder.leetcode.dataStructure.trieTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangzhiwen on 2020/2/26.
 */
public class L212_单词搜索II {
    int rows, cols;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (board == null || board.length == 0) {
            return res;
        }
        rows = board.length;
        cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode ws = root;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                if (ws.children[aChar - 'a'] == null) {
                    ws.children[aChar - 'a'] = new TrieNode();
                }
                ws = ws.children[aChar - 'a'];
            }
            ws.isWord = true;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, root, visited, set, new StringBuilder(""), i, j);
            }
        }
        res.addAll(set);
        return res;
    }
    private void dfs(char[][] board, TrieNode ws, boolean[][] visited, Set<String> set, StringBuilder temp, int i, int j) {
        if (ws.children[board[i][j] - 'a'] == null) return;
        visited[i][j] = true;
        temp.append(board[i][j]);
        if (ws.children[board[i][j] - 'a'].isWord) {
            set.add(temp.toString());
        }
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
                dfs(board, ws.children[board[i][j] - 'a'], visited, set, temp, x, y);
            }
        }
        temp.deleteCharAt(temp.length() - 1);
        visited[i][j] = false;
    }
}
