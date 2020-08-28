package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h=new ListNode(-1),first=h,second=h;
        h.next=head;
        for (int i = 0; i < n; i++) {
            first=first.next;
        }
        while (first.next!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return h.next;
    }
}
