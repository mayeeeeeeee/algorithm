package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

/**
 * Created by wangzhiwen on 2020/1/30.
 */
public class L141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode first = head, second = head.next;
        while (first != second) {
            if(second == null || second.next == null) {
                return false;
            }
            first = first.next;
            second = second.next.next;
        }
        return true;
    }
}
