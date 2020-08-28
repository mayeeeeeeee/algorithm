package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.binaryTree.TreeNode;

/**
 * Created by wangzhiwen on 2020/2/17.
 */
public class L98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if(root == null) {
            return true;
        }
        if(root.val > maxValue || root.val <minValue) {
            return false;
        }
        return dfs(root.left, minValue, (long)root.val - 1) && dfs(root.right, (long)root.val + 1, maxValue);
    }
}
