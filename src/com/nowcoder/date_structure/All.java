package com.nowcoder.date_structure;

import com.nowcoder.double_pointer.ListNode;

import javax.xml.bind.Element;
import java.util.*;

/**
 * Created by wangzhiwen on 2019/9/8.
 */
public class All {
    /**
     * 树相关算法
     */
    public static final int MAXSIZE=100;
    public static void pre_mid_Search(TreeNode t){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=t;
        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                System.out.println(p.val);//pre visit
                p=p.lchild;
            }
            else {
                p = stack.pop();
                //System.out.println(p.val);//mid visit
                p=p.rchild;
            }
        }
    }//前中序非递归遍历
    public static void post_Search(TreeNode t){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=t,r=null;
        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.lchild;
            }
            else {
                p=stack.peek();
                if(p.rchild!=null&&p.rchild!=r){
                    p=p.rchild;
                    stack.push(p);
                    p=p.lchild;
                }
                else {
                    p = stack.pop();
                    System.out.println(p.val);//visit
                    r=p;
                    p=null;
                }
            }
        }
    }//后序非递归遍历
    public static void level_Search(TreeNode t){
        Queue<TreeNode> queue=new LinkedList();
        TreeNode p;
        queue.offer(t);
        while (!queue.isEmpty()){
            p = queue.poll();
            System.out.println(p.val);//visit
            if(p.lchild!=null){
                queue.offer(p.lchild);
            }
            if(p.rchild!=null){
                queue.offer(p.rchild);
            }
        }
    }//层序遍历
    public static TreeNode Ancestor(TreeNode t,TreeNode p,TreeNode q){
        Stack<TreeNode> stack=new Stack<>(),copy=new Stack<>();
        boolean first=true;
        TreeNode k=t,r=null,notvisited=null;
        while (k!=null||!stack.isEmpty()){
            if(k!=null){
                stack.push(k);
                k=k.lchild;
            }
            else {
                k=stack.peek();
                if(k.rchild!=null&&k.rchild!=r){
                    k=k.rchild;
                    stack.push(k);
                    k=k.lchild;
                }
                else {
                    k=stack.pop();
                    if((k==p||k==q)&&first==true){
                        if(k==p){
                            notvisited=q;
                        }
                        else {
                            notvisited=p;
                        }
                        copy = (Stack<TreeNode>) stack.clone();
                        first=false;
                    }
                    if(k==notvisited){
                        k=stack.peek();
                        while (!copy.isEmpty()){
                            if(copy.peek()==k){
                                return copy.peek();
                            }
                        }
                    }
                    r=p;
                    p=null;
                }
            }
        }
        return null;
    }//非递归找最近祖先结点
    public TreeNode Ancestor1(TreeNode root, TreeNode p, TreeNode q) {
        /**
         注意p,q必然存在树内, 且所有节点的值唯一!!!
         递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
         表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
         1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
         2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
         3. 左右子树返回值均为null, p和q均不在树中, 返回null
         **/
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = Ancestor1(root.lchild, p, q);
        TreeNode right = Ancestor1(root.rchild, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }//递归查找最近祖先
    public static boolean isComplete(TreeNode t){
        Queue<TreeNode> queue=new LinkedList();
        TreeNode p;
        queue.offer(t);
        while (!queue.isEmpty()){
             p = queue.poll();
             if(p!=null){
                 queue.offer(p.lchild);
                 queue.offer(p.rchild);
             }
             else{
                 while (!queue.isEmpty()){
                     p = queue.poll();
                     if(p!=null){
                         return false;
                     }
                 }
             }
        }
        return true;
    }//判断是否为完全二叉树
    public static int highth(TreeNode t){
        if(t==null){
            return 0;
        }
        TreeNode[] queue=new TreeNode[MAXSIZE];
        TreeNode p;
        int front=-1,rear=-1,level=0,last=0;//last表示当前层的最右结点index
        queue[++rear]=t;
        while (front<rear){
            p=queue[++front];//front表示当前结点index
            if(p.lchild!=null){
                queue[++rear]=p.lchild;
            }
            if(p.rchild!=null){
                queue[++rear]=p.rchild;
            }
            if(front==last){//说名当前层访问结束
                level++;//统计层信息
                last=rear;//last表示下一层最右结点
            }
        }
        return last;
    }//非递归求树的高度
    public static void PreToPost(TreeNode[] pre,int l1,int h1,TreeNode[] post,int l2,int h2){
        int half;
        if(h1>=l1){
            post[h2]=pre[l1];
            half=(h1-l1)/2;
            PreToPost(pre,l1+1,l1+half,post,l2,l2+half-1);
            PreToPost(pre,l1+half+1,h1,post,l2+half,h2-1);
        }
    }//满二叉树前序转中序

    /**
     * 链表相关算法
     */
    public static void reverse(LinkNode head){
        LinkNode p = head.next,q;
        while (p!=null){
            q=p.next;
            p.next=head.next;
            head.next=p;
            p=q;
        }
    }//链表逆置
    public boolean hasCycle(LinkNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return false;
        LinkNode slow = head.next;//慢指针
        LinkNode fast = head.next.next;//快指针
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;//快指针在循环中追上慢指针
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }//判断链表是否有环
}
