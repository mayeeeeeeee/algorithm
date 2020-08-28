package com.nowcoder.leetcode.hot100;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/1/26.
 */
public class L20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='('||ch=='['||ch=='{'){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) return false;
                if(ch==')'&&stack.pop()!='(') return false;
                if(ch=='}'&&stack.pop()!='{') return false;
                if(ch==']'&&stack.pop()!='[') return false;
            }
        }
        return stack.isEmpty();
    }
}
