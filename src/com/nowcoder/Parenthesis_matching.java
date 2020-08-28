package com.nowcoder;
import java.util.Stack;

/**
 * 括号匹配
 */


public class Parenthesis_matching {
    public static void main(String[] args) {
        System.out.println(trueOrFalse("{()}"));
    }
    public static boolean trueOrFalse(String str) {
        Stack stack = new Stack();
        char []arrays=str.toCharArray();
        for (Character c : arrays) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }

        }
        return stack.isEmpty();
    }

}