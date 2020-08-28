package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

/**
 * Created by wangzhiwen on 2020/1/31.
 */
public class L160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = 0, lb = 0;
        ListNode p = headA, q = headB;
        while (p != null) {
            la++;
            p = p.next;
        }
        while (q != null) {
            lb++;
            q = q.next;
        }
        int diff = la - lb;
        if (diff < 0) {
            diff = 0 - diff;
            p = headB; //长的
            q = headA;
        }
        else {
            p = headA;
            q = headB;
        }
        for (int i = 0; i < diff; i++) {
            p = p.next;
        }
        while (p != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
