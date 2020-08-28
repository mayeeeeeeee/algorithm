package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.binaryTree.TreeNode;

/**
 * Created by wangzhiwen on 2020/2/5.
 */
public class L543_二叉树的直径 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return ans;
    }
    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = deep(root.left), right = deep(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
