package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

/**
 * Created by wangzhiwen on 2020/2/6.
 */
public class L2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode head = new ListNode(-1), p = head;
        while (l1 !=null && l2 != null) {
            int sum = l1.val + l2.val + count;
            p.next = new ListNode(sum % 10);
            p = p.next;
            count = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            l1 = l2;
        }
        while (l1 != null) {
            int sum = count + l1.val;
            p.next = new ListNode(sum % 10);
            p = p.next;
            count = sum / 10;
            l1 = l1.next;
        }
        if (count != 0) {
            p.next = new ListNode(1);
        }
        return head.next;
    }
}
