package com.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiwen on 2019/9/16.
 */
public class Lcode_448_FindDisappearedNumbers {
    public static void main(String[] args) {
        int a[]={4,3,2,7,7,2,3,1};
        System.out.println(findDisappearedNumbers(a));
    }
    public static List<Integer> findDisappearedNumbers(int[] a) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            int index=a[i]-1;
            if(index<0){//只减一次
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
