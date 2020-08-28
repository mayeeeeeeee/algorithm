package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){return null;}
        ListNode p=head,q;
        int cnt=0;
        while (p.next!=null){
            cnt++;
            p=p.next;
        }
        q=p;
        int index=cnt-k%cnt;
        p=head;
        for (int i = 1; i < index; i++) {
            p=p.next;
        }
        q.next=head;
        q=p.next;
        p.next=null;
        return q;
    }
}
