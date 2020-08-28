package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/3.
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 允许在原字符串上操作
 */
public class 替换空格 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
    public static String replaceSpace(StringBuffer str) {
        int j=str.length()-1;//原字符串尾下标
        for (int i=0; i <=j ; i++) {
            if(str.charAt(i)==' '){
                str.append(' ');
                str.append(' ');
            }
        }
        int i=str.length()-1;//新字符串尾下标
        while (j>=0){
            char ch=str.charAt(j);
            if(ch!=' '){
                str.setCharAt(i,ch);
                i--;
                j--;
            }
            else {
                str.setCharAt(i--,'0');
                str.setCharAt(i--,'2');
                str.setCharAt(i--,'%');
                j--;
            }
        }
        return str.toString();
    }
}
