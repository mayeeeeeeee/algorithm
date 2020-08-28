package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/2.
 */
public class L234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if (head == null || head.next ==null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (true) {
            stack.push(slow);
            if (fast.next == null) { //奇数
                stack.pop();
                fast = slow.next;
                break;
            }
            else if (fast.next.next == null) { //偶数
                fast = slow.next;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != fast.val) {
                return false;
            }
            fast = fast.next;
        }
        return true;
    }
}
