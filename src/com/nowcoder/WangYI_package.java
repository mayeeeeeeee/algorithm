package com.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Comparator.*;

/**
 * Created by wangzhiwen on 2019/8/17.
 * in 3 10 //三种零食，背包体积为10
 *    1 2 4 //每种零食的体积
 * out 8   //有多少种放法(总体积为0也是一种放法)
 * 这一类背包问题有两种方法，一种是当物品个数n较少，但是背包大小m比较大时采用指数级的枚举搜索，
 * 复杂度为O(2^n)，另一种是当背包比较小的时候采用动态规划O(nm)
 *
 */
public class WangYI_package {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt(),m=sc.nextInt();
//        int[]a=new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i]=sc.nextInt();
//        }
        int a[]={4,1,2};
        System.out.println(f(8,a,a.length-1));
    }
    public static long f(int []a,int m){ //动态规划
        if(Arrays.stream(a).sum()<=m){
            return (long) Math.pow(2,a.length);
        }
        long []dp=new long[m+1];
        Arrays.fill(dp,1);
        for (int i = 0; i < a.length; i++) {
            for (int j = m; j >0 ; j--) {
                if(j>=a[i]){
                    dp[j]=dp[j-a[i]]+dp[j];
                }
            }
        }
        return dp[m];
    }
    public static long f(long m,int []a,int n){//递归，m为总体积，n为零食下标
        if(m==0){
            return 1;
        }
        if(n==0){
            if(m>=a[n]){
                return 2;
            }else
            {
                return 1;
            }
        }
        if(m>=a[n]) {
            return f(m-a[n],a,n-1)+f(m,a,n-1);
        }
        else {
            return f(m,a,n-1);
        }
    }

}
