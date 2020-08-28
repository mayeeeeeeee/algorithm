package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len=0;
        ListNode p=headA,q;
        while (p!=null){
            len++;
            p=p.next;
        }
        p=headB;
        while (p!=null){
            len--;
            p=p.next;
        }
        if(len>0){
            p=headA;
            q=headB;
        }
        else {
            p=headB;
            q=headA;
        }
        while ((len=Math.abs(len))!=0){
            len--;
            p=p.next;
        }
        while (p!=null){
            if (p==q){
                return p;
            }
            p=p.next;
            q=q.next;
        }
        return null;
    }
}
