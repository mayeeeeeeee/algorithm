package com.nowcoder;

import com.sun.javafx.event.EventDispatchChainImpl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by wangzhiwen on 2019/8/3.
 * input:
 * 3 3 1
 * [1 3 3
 *  2 4 9
 *  8 9 2]
 * output:6
 * 先检验一下都失败的情况(边界情况)
 */
public class Yuan2_Maze {

    public static void main(String[] args) {
        int [][]a={{1,3,3},
                    {2,4,9},
                    {8,9,2}};//out:6
        //int[][]a={{1,2}};//out:4
        System.out.println(f(a,0,0,1)+1);
    }
    public static int f(int[][]a,int m,int n,int k){
        int rows=a.length,cols=a[0].length;
        int up=0,down=0,left=0,right=0;
        if(m+1<rows)
        {
            if(a[m+1][n]>a[m][n])
            {
                down=f(a,m+1,n,k)+1;
            }
            else if(k==1)
            {
                k--;
                down=f(a,m+1,n,k)+1;
            }
        }
        if(m-1>=0)
        {
            if(a[m-1][n]>a[m][n])
            {
                up=f(a,m-1,n,k)+1;
            }
            else if(k==1)
            {
                k--;
                up=f(a,m-1,n,k)+1;
            }
        }
        if(n+1<cols)
        {
            if (a[m][n + 1] > a[m][n]) {
                right = f(a, m, n + 1, k)+1;
            }
            else if(k==1){
                k--;
                right = f(a, m, n + 1, k)+1;
            }
        }
        if(n-1>=0)
        {
            if(a[m][n-1]>a[m][n]){
                left = f(a, m, n - 1, k)+1;
            }
            else if(k==1)
            {
                k--;
                left = f(a, m, n - 1, k)+1;
            }
        }
        return Math.max(Math.max(up,down),Math.max(left,right));
    }
}
