package com.nowcoder.joffer;

import com.nowcoder.date_structure.LinkNode;
import com.nowcoder.double_pointer.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/10/5.
 */
public class 从尾到头打印链表 {
    public static void main(String[] args) {
        LinkNode a=new LinkNode(1);
        System.out.println(printListFromTailToHead(a));
    }
    public static ArrayList<Integer> printListFromTailToHead(LinkNode listNode) {
        ArrayList<Integer> res=new ArrayList<>();
        LinkNode p=listNode;
        while (p!=null){
            res.addAll(printListFromTailToHead(p.next));
            res.add(p.val);
        }
        return res;
    }
}
