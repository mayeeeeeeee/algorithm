package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.binaryTree.TreeNode;


/**
 * Created by wangzhiwen on 2020/2/4.
 */
public class L538_把二叉搜索树转换为累加树 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        searchRoot(root);
        return root;
    }

    private void searchRoot(TreeNode root) {
        if (root != null) {
            searchRoot(root.right);
            sum += root.val;
            root.val = sum;
            searchRoot(root.left);
        }
    }
}
