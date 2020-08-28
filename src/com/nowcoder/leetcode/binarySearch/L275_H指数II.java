package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/13.
 */
public class L275_H指数II {
    public int hIndex(int[] citations) {
        int l=0,r=citations.length;
        while (l<r){
            int mid=r+l+1>>1;
            if(mid<=citations[citations.length-mid]){
                l=mid;
            }
            else {
                r=mid-1;
            }
        }
        return l;
    }
}
