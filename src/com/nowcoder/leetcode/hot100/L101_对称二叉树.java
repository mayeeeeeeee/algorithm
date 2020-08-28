package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.binaryTree.TreeNode;

/**
 * Created by wangzhiwen on 2020/1/28.
 */
public class L101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetrictwo(root.left,root.right);
    }

    private boolean isSymmetrictwo(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left!=null&&right!=null&&left.val==right.val){
            return isSymmetrictwo(left.left, right.right) && isSymmetrictwo(left.right, right.left);
        }
        return false;
    }
}
