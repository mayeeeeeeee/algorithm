package com.nowcoder.leetcode.dataStructure.binaryTree;

/**
 * Created by wangzhiwen on 2019/10/17.
 */
public class L543_二叉树的直径 {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        h(root);
        return res;
    }
    public int h(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int l=h(root.left),r=h(root.right);
        res=Math.max(res,l+r);
        return (l<r?r:l)+1;
    }
}
