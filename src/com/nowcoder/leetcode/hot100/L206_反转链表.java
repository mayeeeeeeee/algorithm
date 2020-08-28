package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L206_反转链表 {
    //头插法 单独处理第一个节点
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode r=new ListNode(-1);
        r.next=head;
        ListNode p=head.next,q;
        head.next=null;
        while (p!=null){
            q=p.next;
            p.next=r.next;
            r.next=p;
            p=q;
        }
        return r.next;
    }
    //递归
    public ListNode reverseList1(ListNode head) {
       if (head==null||head.next==null){
           return head;
       }
       ListNode p=head.next;
       ListNode headnew=reverseList1(p);
       p.next=head;
       return headnew;
    }
}
