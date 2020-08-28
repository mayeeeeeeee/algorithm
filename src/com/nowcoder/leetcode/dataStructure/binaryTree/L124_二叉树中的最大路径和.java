package com.nowcoder.leetcode.dataStructure.binaryTree;

/**
 * Created by wangzhiwen on 2019/10/17.
 */
public class L124_二叉树中的最大路径和 {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        m(root);
        return res;
    }
    public int m(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=m(root.left),r=m(root.right);
        res=Math.max(res,l+r+root.val);
        return Math.max(0,(l<r?r:l)+root.val);
    }
}
