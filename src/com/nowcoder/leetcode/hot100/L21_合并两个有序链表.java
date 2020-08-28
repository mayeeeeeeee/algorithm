package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

/**
 * Created by wangzhiwen on 2020/1/27.
 */
public class L21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(-1),cur=l3;
        while (l1!=null&&l2!=null){
            if(l1.val>=l2.val){
                cur.next=l2;
                l2=l2.next;
            }
            else {
                cur.next=l1;
                l1=l1.next;
            }
            cur=cur.next;
        }
        if(l1==null){
            l1=l2;
        }
        cur.next=l1;
        return l3.next;
    }

    //递归实现(新建节点)
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(-1),cur=l3;
        merge(l1,l2,cur);
        return l3.next;
    }

    private void merge(ListNode l1, ListNode l2, ListNode cur) {
        if(l1==null){
            cur.next=l2;
            return;
        }
        if(l2==null){
            cur.next=l1;
            return;
        }
        if(l1.val<=l2.val){
            cur.next=l1;
            merge(l1.next,l2,cur.next);
        }
        else {
            cur.next=l2;
            merge(l1,l2.next,cur.next);
        }
    }

    //递归实现(使用原节点)评论区答案
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<=l2.val){
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }
        else {
            l2.next=mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}
