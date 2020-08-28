package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L92_反转链表ll {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null){
            return null;
        }
        int cnt=1;
        ListNode r=new ListNode(-1),p=head,q;
        r.next=head;
        ListNode pre=r;
        while (cnt!=m-1){
            p=p.next;
            cnt++;
        }
        pre=p;
        p=pre.next;
        q=p.next;
        p.next=null;
        cnt+=2;
        while (cnt!=n+1){
            ListNode temp=q.next;
            q.next=pre.next;
            pre.next=q;
            q=temp;
            cnt++;
        }
        p.next=q;
        return r.next;
    }
}
