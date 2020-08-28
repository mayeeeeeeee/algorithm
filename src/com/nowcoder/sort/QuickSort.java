package com.nowcoder.sort;

/**
 * Created by wangzhiwen on 2019/3/2.
 */
public class QuickSort {
    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }

    public static void main(String[] args) {
        int []a={6,3,7,4,1};
        int len=a.length;
        sort(a,0,len-1);
        for (int i :
                a) {
            System.out.println(i);
        }
    }

}
