package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhiwen on 2020/2/18.
 */
public class L105_从前序与中序遍历序列构造二叉树 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int prel, int prer, int midl, int midr) {
        if (prel > prer) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prel]);
        int mid = map.get(preorder[prel]);
        root.left = build(preorder, inorder, prel + 1, prel + mid - midl, midl, mid - 1);
        root.right = build(preorder, inorder, prel + mid - midl + 1, prer, mid + 1, midr);
        return root;
    }
}
