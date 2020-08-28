package com.nowcoder.leetcode.dataStructure.binaryTree;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/10/16.
 */
public class L98_验证二叉树 {
    //非递归
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        TreeNode p=root;
        long pre=(long)Integer.MIN_VALUE-1;
        while(p!=null||!s.isEmpty()){
            if(p!=null){
                s.push(p);
                p=p.left;
            }
            else {
                p=s.pop();
                if(p.val<=pre){
                    return false;
                }
                pre=p.val;
                p=p.right;
            }
        }
        return true;
    }
    //递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long l,long r){
        if(root==null){
            return true;
        }
        if(root.val>=l&&root.val<=r){
            return isValidBST(root.left,l,(long)root.val-1)&&isValidBST(root.right,(long)root.val+1,r);
        }
        return false;
    }
}
