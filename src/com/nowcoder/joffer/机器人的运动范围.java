package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/5.
 */
public class 机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag=new boolean[rows][cols];
        return find(threshold,0,0,rows,cols,flag);
    }
    public int find(int m,int i,int j,int rows,int cols,boolean[][] flag){
        int sum=0,i1=i,j1=j;
        while (i1!=0){
            sum+=i1%10;
            i1/=10;
        }
        while (j1!=0){
            sum+=j1%10;
            j1/=10;
        }
        if(i<0||i>=rows||j<0||j>=cols||sum>m||flag[i][j]){
            return 0;
        }
        flag[i][j]=true;
        return find(m,i-1,j,rows,cols,flag)+find(m,i+1,j,rows,cols,flag)+find(m,i,j+1,rows,cols,flag)+find(m,i,j-1,rows,cols,flag)+1;
    }
}
