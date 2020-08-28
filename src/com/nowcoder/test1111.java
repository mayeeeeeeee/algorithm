package com.nowcoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by wangzhiwen on 2019/9/11.
 */
public class test1111 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int flag=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='0'){
                System.out.println(flag);
            }
            if(c=='('){
                flag++;
            }
            if(c==')'){
                flag--;
            }
        }
    }
    private static int solution(int[] in) {
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:in){
            if(!map.containsKey(i))
                map.put(i,1);
            else {
                int count=map.get(i);
                map.put(i,count+1);
            }
        }
        for(int k:map.keySet()){
            res=res+(int)Math.pow(map.get(k),2);
        }
        return res;
    }
}
