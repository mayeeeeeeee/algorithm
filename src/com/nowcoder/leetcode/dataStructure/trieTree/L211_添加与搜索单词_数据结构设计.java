package com.nowcoder.leetcode.dataStructure.trieTree;

/**
 * Created by wangzhiwen on 2020/2/26.
 */
public class L211_添加与搜索单词_数据结构设计 {
    private TrieNode root;
    public L211_添加与搜索单词_数据结构设计() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = ws.children[word.charAt(i) - 'a'];
            if (child == null) {
                child = new TrieNode();
            }
            ws = child;
        }
        ws.isWord = true;
    }
    public boolean search(String word) {
        return match1(word.toCharArray(), root, 0);
    }
    //只遇到'.'时递归
    private boolean match1(char[] chars, TrieNode ws, int curr) {
        for (int i = curr; i < chars.length; i++) {
            char c = chars[i];
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (ws.children[j] != null && match1(chars, ws.children[j], i + 1)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
        }
        return ws.isWord;
    }
    //完全递归
    private boolean match(char[] chars, TrieNode ws, int curr) {
        if (curr == chars.length) {
            return ws.isWord;
        }
        if (chars[curr] == '.') {
            for (int i = 0; i < ws.children.length; i++) {
                if (ws.children[i] != null && match(chars, ws.children[i], curr + 1)) {
                    return true;
                }
            }
        } else {
            return ws.children[chars[curr] - 'a'] != null && match(chars, ws.children[chars[curr] - 'a'], curr + 1);
        }
        return false;
    }
}
