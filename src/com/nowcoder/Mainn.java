package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/9/15.
 */
public class Mainn {
    public static void main(String[] args) {
        int a[]={3,2,2,1};
        System.out.println(f(a,0,3));
    }
    public static int f(int[] a,int i,int j){
        if(j-i==1){
            return a[i]>a[j]?a[i]:a[j];
        }
        int a1=f(a,i+1,j),a2=f(a,i,j-1);//a1表示先拿左，a2表示先拿右；
        return a1>a2?sum(a,i,j)-a2:sum(a,i,j)-a1;
    }
    public static int sum(int []a,int i,int j){
        int res=0;
        for (int k = i; k <=j ; k++) {
            res+=a[k];
        }
        return res;
    }
}
