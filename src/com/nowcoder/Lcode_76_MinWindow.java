package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/9/12.
 */

import java.util.*;

public class Lcode_76_MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        int match=0,res=Integer.MAX_VALUE,start=0;
        Map<Character,Integer> map=new HashMap<>(),map1=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0,r=0;
        while (r<s.length()){
            char ch=s.charAt(r);
            if(map.containsKey(ch)){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(Objects.equals(map.get(ch), map1.get(ch))){
                    match++;
                }
            }
            r++;
            while (match==map.size()){
                if(r-l<res){
                    res=r-l;
                    start=l;
                }
                char chl=s.charAt(l);
                if(map.containsKey(chl)){
                    map1.put(chl,map1.getOrDefault(chl,0)-1);
                    if(map.get(chl)>map1.get(chl)){
                        match--;
                    }
                }
                l++;
            }
        }
        return res==Integer.MAX_VALUE?"":s.substring(start,res+start);
    }
}