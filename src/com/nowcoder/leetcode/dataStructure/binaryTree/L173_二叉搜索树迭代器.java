package com.nowcoder.leetcode.dataStructure.binaryTree;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/10/17.
 */
public class L173_二叉搜索树迭代器 {
    Stack<TreeNode> stack=new Stack<>();
    public L173_二叉搜索树迭代器(TreeNode root) {
        TreeNode p=root;
        while (p!=null){
            stack.push(p);
            p=p.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stack.pop();
        int res= p.val;
        p=p.right;
        while (p!=null){
            stack.push(p);
            p=p.left;
        }
        return res;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
