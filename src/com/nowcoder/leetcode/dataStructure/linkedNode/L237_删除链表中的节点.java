package com.nowcoder.leetcode.dataStructure.linkedNode;

/**
 * Created by wangzhiwen on 2019/10/14.
 */
public class L237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
