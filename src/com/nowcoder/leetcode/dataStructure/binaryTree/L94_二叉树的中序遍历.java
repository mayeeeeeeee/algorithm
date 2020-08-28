package com.nowcoder.leetcode.dataStructure.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/10/16.
 */
public class L94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode p=root;
        while (p!=null||!s.isEmpty()){
            if(p!=null){
                s.push(p);
                p=p.left;
            }
            else {
                p=s.pop();
                res.add(p.val);
                p=p.right;
            }
        }
        return res;
    }
}
