package com.nowcoder;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;

/**
 * Created by wangzhiwen on 2019/9/15.
 */
public class Lcode_438_FindAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("aa","bb"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int match=0,l=0,r=0;
        if(s.length()<p.length())
            return res;
        Map<Character,Integer> maps=new HashMap<>(),mapp=new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            mapp.put(p.charAt(i),mapp.getOrDefault(p.charAt(i),0)+1);
        }
        while (r<s.length()){
            char ch=s.charAt(r);
            if(mapp.containsKey(ch)){
                maps.put(ch,maps.getOrDefault(ch,0)+1);
                if(mapp.get(ch).equals(maps.get(ch))){
                    match++;
                }
            }
            r++;
            while (match==mapp.size()){
                char chl=s.charAt(l);
                if(r-l==p.length()){
                    res.add(l);
                }
                if(mapp.containsKey(chl)){
                   maps.put(chl,maps.getOrDefault(chl,0)-1);
                   if(maps.get(chl)<mapp.get(chl)){
                       match--;
                   }
                }
                l++;
            }
        }
        return res;
    }
}
