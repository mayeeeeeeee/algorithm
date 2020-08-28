package com.nowcoder.leetcode.hot100;

import java.util.*;

/**
 * Created by wangzhiwen on 2020/3/7.
 */
public class L347_前K个高频元素 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i :
                nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        List []sort=new List[nums.length+1];
        Iterator<Map.Entry<Integer,Integer>> iterator=mp.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry=iterator.next();
            if(sort[entry.getValue()]==null){
                sort[entry.getValue()]=new ArrayList();
            }
            sort[entry.getValue()].add(entry.getKey());
        }
        List res=new ArrayList();
        for (int i = sort.length-1; i > 0 ; i--) {
            if(sort[i]!=null){
                int len=sort[i].size();
                if(k>len)
                {
                    res.addAll(sort[i]);
                    k-=len;
                }
                else if(k==len){
                    res.addAll(sort[i]);
                    break;
                }
                else{
                    res.addAll(sort[i].subList(0, k - len));
                    break;
                }
            }
        }
        return res;
    }
}
