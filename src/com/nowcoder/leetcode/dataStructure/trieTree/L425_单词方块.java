package com.nowcoder.leetcode.dataStructure.trieTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhiwen on 2020/2/27.
 */
public class L425_单词方块 {
    public static void main(String[] args) {
        System.out.println(new L425_单词方块().wordSquares(new String[]{"ball", "area", "lead", "lady"}));
    }
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (words.length == 0) return ans;
        int size = words[0].length();
        Map<String, List<String>> prefixes = new HashMap<>();
        getPrefixes(prefixes, words);
        List<String> sub = new ArrayList<>();
        dfs(ans, sub, size, prefixes);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> sub, int size, Map<String, List<String>> prefixes) {
        if (sub.size() == size) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        int rowNum = sub.size();
        StringBuilder prefix = new StringBuilder("");
        for (int i = 0; i < rowNum; i++) {
            prefix.append(sub.get(i).charAt(rowNum));
        }
        String prefixS = prefix.toString();
        if (!prefixes.containsKey(prefixS)) return;
        for (String word : prefixes.get(prefixS)) {
            sub.add(word);
            dfs(ans, sub, size, prefixes);
            sub.remove(sub.size() - 1);
        }
        return;
    }

    private void getPrefixes(Map<String, List<String>> prefixes, String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i);
                prefixes.computeIfAbsent(sub, k -> new ArrayList<>()).add(word);
            }
        }
    }
}
