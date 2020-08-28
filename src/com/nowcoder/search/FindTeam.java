package com.nowcoder.search;

import java.util.Scanner;
import java.lang.Thread;
/**
 * Created by wangzhiwen on 2019/8/5.
 * in:a[m][n]如下矩阵  相邻(上下左右斜)算一个阵营
 * out:阵营数6，最大阵营人数8
 *
 */
public class FindTeam {
    public static void main(String[] args) {
        int m=10,n=10;
        int max=0,res=0,temp;
        int a[][]={ {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,1,0,1,0,0,0},
                    {0,1,0,0,0,0,0,1,0,1},
                    {1,0,0,0,0,0,0,0,1,1},
                    {0,0,0,1,1,1,0,0,0,1},
                    {0,0,0,0,0,0,1,0,1,1},
                    {0,1,1,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,0,0,0},
                    {0,0,1,0,0,1,0,0,0,0},
                    {0,1,0,0,0,0,0,0,0,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                    res++;
                    temp=find(a,i,j);
                    if(temp>max)
                    {
                        max=temp;
                    }
                    System.out.println("("+i+","+j+")人数"+temp);
                }
            }
        }
        System.out.println("阵营数"+res+"------最大人数"+max);
    }
    static int find(int [][]a,int m,int n){//传入当已前确认点坐标，返回阵营人数
        int rows=a.length,cols=a[0].length,res=1;
        if(m-1>=0&&n+1<cols&&a[m-1][n+1]==1){
            a[m-1][n+1]=2;
            res+=find(a,m-1,n+1);
        }
        if(n+1<cols&&a[m][n+1]==1){
            a[m][n+1]=2;
            res+=find(a,m,n+1);
        }
        if(m+1<rows&&a[m+1][n]==1) {
            a[m+1][n]=2;
            res+=find(a,m+1,n);
        }
        if(m+1<rows&&n-1>=0&&a[m+1][n-1]==1)
        {
            a[m+1][n-1]=2;
            res+=find(a,m+1,n-1);
        }
        if(m+1<rows&&n+1<cols&&a[m+1][n+1]==1){
            a[m+1][n+1]=2;
            res+=find(a,m+1,n+1);
        }
        return res;
    }

}