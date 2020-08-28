package com.nowcoder.joffer;

import com.nowcoder.date_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhiwen on 2019/10/5.
 */
public class 重建二叉树 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param pre {1,2,4,7,3,5,6,8}
     * @param in  {4,7,2,1,5,3,8,6}
     * @return
     */
    private static Map<Integer,Integer> map=new HashMap<>();
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return reConstructBinaryTree(pre, 0, pre.length-1, 0);
    }
    public static TreeNode reConstructBinaryTree(int []pre,int pl,int pr,int inl){
        if(pl>pr){
            return null;
        }
        TreeNode root=new TreeNode(pre[pl]);
        int index=map.get(pre[pl]),llen=index-inl;
        root.lchild=reConstructBinaryTree(pre,pl+1,pl+llen,inl);
        root.rchild=reConstructBinaryTree(pre,pl+llen+1,pr,index+1);
        return root;
    }
}
