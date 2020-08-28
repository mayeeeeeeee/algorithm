package com.nowcoder.leetcode.dataStructure.stack;

import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L394_字符串解码 {
    //用一个栈
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                stack.push(ch);
            }
            else {
                StringBuilder temp = new StringBuilder("");
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                stack.pop();
                int len = 0, m = 1;
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    len += m * (stack.pop() - '0');
                    m *= 10;
                }
                for (int j = 0; j < len; j++) {
                    for (int k = 0; k < temp.length(); k++) {
                        stack.push(temp.charAt(temp.length() - 1 - k));
                    }
                }
            }
        }
        char[] resArray = new char[stack.size()];
        int index = resArray.length - 1;
        while (!stack.isEmpty()) {
            resArray[index--] = stack.pop();
        }
        return String.valueOf(resArray);
    }
    //用两个栈
}
