package com.nowcoder.leetcode.dataStructure.binaryTree;

/**
 * Created by wangzhiwen on 2019/10/16.
 * 只能假设p、q只存在一个的时候返回自身
 */
public class L236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null){
            return root;
        }
        TreeNode l=lowestCommonAncestor(root.left,p,q),r=lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null){
            return root;
        }
        if(l!=null){
            return l;
        }
        if(r!=null){
            return r;
        }
        return null;
    }
}
