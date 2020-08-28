package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p=head;
        while (p!=null&&p.next!=null){
            if(p.val==p.next.val){
                p.next=p.next.next;
            }
            else{
                p=p.next;
            }
        }
        return head;
    }
}
