package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L142_环形链表ll {
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
        slow=head;
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(slow==fast){
                return slow;
            }
        }
        return null;
    }
}
