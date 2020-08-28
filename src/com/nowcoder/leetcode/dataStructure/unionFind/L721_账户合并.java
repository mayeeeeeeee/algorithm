package com.nowcoder.leetcode.dataStructure.unionFind;

import java.util.*;

/**
 * Created by wangzhiwen on 2020/2/25.
 */
public class L721_账户合并 {
    public static void main(String[] args) {
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts.size() == 0) {
            return res;
        }

        UnionFind uf = new UnionFind(accounts.size());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
//                if (!map.containsKey(email)) {
//                    map.put(email, i);
//                }
//                else {
//                    uf.connect(map.get(email), i);
//                }
                map.putIfAbsent(email, i);
                uf.connect(map.get(email), i);
            }
        }

        HashMap<Integer, List<String>> indexEmail = new HashMap<>();
        for (String email : map.keySet()) {
            int root = uf.find(map.get(email));
            indexEmail.putIfAbsent(root, new ArrayList<>());
            indexEmail.get(root).add(email);
        }

        for (Integer index : indexEmail.keySet()) {
            List<String> account = new ArrayList<>();
            account.add(accounts.get(index).get(0));

            List<String> emails = indexEmail.get(index);
            Collections.sort(emails);

            account.addAll(emails);
            res.add(account);
        }

        return res;
    }
}
