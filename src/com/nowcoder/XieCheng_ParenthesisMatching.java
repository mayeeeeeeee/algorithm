package com.nowcoder;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XieCheng_ParenthesisMatching {

    public static void main(String[] args){
        String s="((ui)(or))";//orui
        System.out.println(f(s));
    }
    public static StringBuilder f(String in){
        Stack<Character> s=new Stack();
        for (int i = 0; i < in.length(); i++) {
            char ch=in.charAt(i);
            if(ch=='('){
                s.push(ch);
            }
            else if(ch==')'){
                ff(s);
            }
            else {
                s.push(ch);
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        ff(s);
        while (!s.isEmpty()){
            char c=s.pop();
            stringBuilder.append(c);
        }
        return stringBuilder;
    }
    public static void ff(Stack<Character> s){
        char ch;
        List<Character> l=new ArrayList();
        while (!s.isEmpty()&&(ch=s.pop())!='('){
            l.add(ch);
        }
        for (int i = 0; i < l.size(); i++) {
            s.push(l.get(i));
        }
    }

}