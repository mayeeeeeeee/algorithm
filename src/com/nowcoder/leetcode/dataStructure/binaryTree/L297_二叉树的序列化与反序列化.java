package com.nowcoder.leetcode.dataStructure.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2019/10/16.
 */
public class L297_二叉树的序列化与反序列化 {
    // Encodes a binaryTree to a single string.
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        String serialize = new L297_二叉树的序列化与反序列化().serialize(root);
        System.out.println(serialize);
        System.out.println(new L297_二叉树的序列化与反序列化().deserialize(serialize).val);
    }
    public String serialize(TreeNode root) {
        StringBuilder res=new StringBuilder("[");
        if(root==null){
            return "[]";
        }
        List<TreeNode> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int flag=0;
            int len=q.size();
            for (int i = 0; i < len; i++) {
                TreeNode p=q.poll();
                list.add(p);
                if(p!=null){
                    q.offer(p.left);
                    q.offer(p.right);
                    flag=1;
                }
            }
            if(flag==0){
                break;
            }
        }
        for (int i = list.size()-1; list.get(i)==null ; i--) {
            list.remove(i);
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode t=list.get(i);
            if(t!=null){
                res.append(t.val);
                res.append(',');
            }
            else {
                res.append("null,");
            }
        }
        res.replace(res.length()-1,res.length(),"]");
        return res.toString();
    }

    // Decodes your encoded data to binaryTree.
    public TreeNode deserialize(String data) {
        if(data=="[]"){
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> q=new LinkedList();
        int i=0;
        TreeNode root=new TreeNode(Integer.valueOf(split[i]));
        q.offer(root);
        while (!q.isEmpty()){
             TreeNode p=q.poll();
             if(i+1<split.length&&!split[i+1].equals("null")){
                 p.left=new TreeNode(Integer.valueOf(split[i+1]));
                 q.offer(p.left);
             }
             if(i+2<split.length&&!split[i+2].equals("null")){
                 p.right=new TreeNode(Integer.valueOf(split[i+2]));
                 q.offer(p.right);
             }
             i+=2;
        }
        return root;
    }

}
