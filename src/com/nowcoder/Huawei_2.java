package com.nowcoder;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/4/3.
 * 输入：abc3(D3(A))
 * 输出：AAADAAADAAADcba
 */
public class Huawei_2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
               String str=in.next();
               StringBuilder res=new StringBuilder("");//结果字符串
               res=f(res,str);
               //控制输出
               for(int i=0;i<res.length();i++){
                   System.out.print(res.charAt(res.length()-i-1));
               }
            }
        }
        public static StringBuilder f(StringBuilder res,String str){
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){//字母直接加入结果集
                    res.append(ch);
                }
                else if(str.charAt(i)>='0'&&str.charAt(i)<='9'){//处理数字
                    int len=str.charAt(i)-'0';//字符转数字
                    char ch1=str.charAt(i+1);//左括号
                    int flag=0;
                    if(ch1=='('){//如果是左小括号
                        flag++;//控制同种括号嵌套
                        int left=i+1,right=i+2;
                        //得到括号内字符串左右指针
                        while (str.charAt(right)!=')'||flag!=1){
                            if(str.charAt(right)=='('){
                                flag++;
                            }
                            if(str.charAt(right)==')'){
                                flag--;
                            }
                            right++;
                        }
                        String temp=str.substring(left+1,right);//得到括号内字符串
                        i=right;
                        for(int j=0;j<len;j++){
                            res=f(new StringBuilder(res),temp);//对括号内字符串进行递归操作
                        }
                    }
                    else if(ch1=='['){//如果左中括号，处理同上
                        flag++;
                        int left=i+1,right=i+2;//( )
                        while (str.charAt(right)!=']'||flag!=1){
                            if(str.charAt(right)=='['){
                                flag++;
                            }
                            if(str.charAt(right)==']'){
                                flag--;
                            }
                            right++;
                        }
                        String temp=str.substring(left+1,right);//A
                        i=right;
                        for(int j=0;j<len;j++){
//                            System.out.println(temp);
                            res=f(new StringBuilder(res),temp);//res A
                            //    System.out.println(res.toString()+"kkk");
                        }
                    }
                    else if(ch1=='{'){//如果左大括号，处理同上
                        flag++;
                        int left=i+1,right=i+2;//( )
                        while (str.charAt(right)!='}'||flag!=1){
                            if(str.charAt(right)=='{'){
                                flag++;
                            }
                            if(str.charAt(right)=='}'){
                                flag--;
                            }
                            right++;
                        }
                        String temp=str.substring(left+1,right);//A
                        i=right;
                        for(int j=0;j<len;j++){
//                            System.out.println(temp);
                            res=f(new StringBuilder(res),temp);//res A
                            //    System.out.println(res.toString()+"kkk");
                        }
                    }

                }

            }
            return res;
        }

}
