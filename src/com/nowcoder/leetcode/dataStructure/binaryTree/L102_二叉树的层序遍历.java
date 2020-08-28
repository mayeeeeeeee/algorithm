package com.nowcoder.leetcode.dataStructure.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2019/10/16.
 */
public class L102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode p = root;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> curlevel = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                p = queue.poll();
                curlevel.add(p.val);
                if(p.left != null) {
                    queue.offer(p.left);
                }
                if(p.right != null) {
                    queue.offer(p.right);
                }
            }
            res.add(curlevel);
        }
        return res;
    }
}
