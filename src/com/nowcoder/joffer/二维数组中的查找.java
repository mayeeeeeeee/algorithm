package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/3.
 * 1 2 3
 * 2 3 4
 * 3 4 5
 * 4 5 6
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {
        int[][]a={{1,2,3},{2,3,4},{3,4,5},{4,5,6}};
        System.out.println(f(a,4));
    }
    public static boolean f(int a[][],int target){
        if(a==null||a.length==0)
            return false;
        int rows=a.length,cols=a[0].length,x0=0,y0=cols-1,x=x0,y=y0;
        while (true){
            if(x==rows||y==-1){
                x=++x0;
                y=--y0;
                if(x0==rows||y0==-1){
                    return false;
                }
            }
            if(a[x][y]==target){
                return true;
            }
            else if(a[x][y]<target){
                x++;
            }
            else {
                y--;
            }
        }
    }
}
