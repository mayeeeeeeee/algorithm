package com.nowcoder.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiwen on 2020/2/3.
 */
public class L448_找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] a) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            int index=a[i]-1;
            if(index<0){
                index+=a.length;
            }
            if(a[index]>=1){
                a[index]-=a.length;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i]>=1){
                res.add(i+1);
            }
        }return res;
    }
}
