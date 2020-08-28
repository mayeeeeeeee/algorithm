package com.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输入：{1,1,1,2,2,3},2  输出[1.2]
 * 遍历map四种方式
 * 1、for (Map.Entry<Integer, Integer> entry : map.entrySet()) {...}
 * 2、for (Integer key : map.keySet()) {...}  只用key或value for (Integer value : map.values()) {...}
 * 3、Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
 *   while (entries.hasNext()) {
 *   Map.Entry<Integer, Integer> entry = entries.next();
 *      ......
 *    }
 * 4、方法2的keySet()根据键来查值，较慢
 */
public class TopKFrequent {
    public static void main(String []args){
        int []nums={1,1,1,2,2,3};
        System.out.println(topKFrequent(nums,2));
    }
    public static List<Integer> topKFrequent(int []nums,int k){
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        List<Integer>[] lists=new ArrayList[nums.length+1];
        for(int key:mp.keySet()){
            int value=mp.get(key);
            if(lists[value]==null){
                lists[value]=new ArrayList<>();
            }
            lists[value].add(key);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=lists.length-1;i>0&&res.size()<k;i--){
            if(lists[i]!=null){
                res.addAll(lists[i]);
            }
        }
        return res;
    }
}
