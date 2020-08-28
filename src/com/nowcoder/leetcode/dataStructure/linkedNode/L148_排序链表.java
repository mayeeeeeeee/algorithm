package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/15.
 */
public class L148_排序链表 {
    public ListNode sortList(ListNode head) {
        ListNode r=new ListNode(-1),p=head;
        int n=0;
        r.next=head;
        while (p != null) {
            n++;
            p=p.next;
        }
        return null;
    }
}
