package com.nowcoder.leetcode.dataStructure.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhiwen on 2019/10/16.
 */
public class L105_从前序与中序遍历序列构造二叉树 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree1(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree1(int[] preorder, int prel, int prer, int[] inordef, int inl, int inr) {
        if(prel > prer) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prel]);
        int index = map.get(preorder[prel]);
        root.left = buildTree1(preorder, prel+1, prel + index - inl, inordef, inl, index - 1);
        root.right = buildTree1(preorder, prel + index - inl + 1, prer, inordef, index + 1, inr);
        return root;
    }
}
