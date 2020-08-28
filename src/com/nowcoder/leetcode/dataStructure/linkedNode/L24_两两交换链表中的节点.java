package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode p=head,b=new ListNode(-1),q,r;
        b.next=head;
        r=b;
        while (p!=null&&p.next!=null){
            q=p.next;
            p.next=q.next;
            b.next=q;
            q.next=p;
            b=p;
            p=p.next;
        }
        return r;
    }
}
