package com.nowcoder.leetcode.hot100;

import com.nowcoder.leetcode.dataStructure.linkedNode.ListNode;

/**
 * Created by wangzhiwen on 2020/2/19.
 */
public class L142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }
            else {
                return null;
            }
            if(fast==slow){
                break;
            }
        }
        fast=head;
        while (slow != null){
            slow=slow.next;
            fast=fast.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
}
