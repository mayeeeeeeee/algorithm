package com.nowcoder;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/8/3.
 * input:  "((A2B)2)2G"
 * output: AABAABAABAABG
 */
public class Yuan1_CharactoerDecoder {
    public static void main(String[] args) {
        String in="((A2B)2)2G";//AABAABAABAABG
        System.out.println(f(in));
    }
    public static StringBuilder f(String input){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch=input.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }
            else if(ch>='A'&&ch<='Z'){
                if(i+1<input.length()&&input.charAt(i+1)>='0'&&input.charAt(i+1)<='9'){
                    for (int j = 0; j < input.charAt(i+1)-'0'; j++) {
                        stack.push(ch);
                    }
                    i++;
                }
                else {
                    stack.push(ch);
                }
            }
            else if(ch==')'){
                int count=0;
                if(i+1<input.length()){
                    count=input.charAt(i+1)-'0';
                    i++;
                    ff(stack,count);
                }
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse();
    }

    private static void ff(Stack<Character> stack, int count) {
        List<Character> l = new ArrayList<>();
        char ch;
        while (!stack.isEmpty()&&(ch=stack.pop())!='('){
            l.add(ch);
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < l.size(); j++) {
                stack.push(l.get(l.size()-j-1));
            }
        }
    }
}
