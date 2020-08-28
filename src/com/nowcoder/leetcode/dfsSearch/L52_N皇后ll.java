package com.nowcoder.leetcode.dfsSearch;

/**
 * Created by wangzhiwen on 2019/10/25.
 *
 */
public class L52_N皇后ll {
    private int len,res=0;
    public int totalNQueens(int n) {
       len=n;
       int[] cols=new int[n];
       int[] leftdown=new int[n*2-1];
       int[] leftup=new int[n*2-1];
       dfs(0,cols,leftdown,leftup);
       return res;
    }
    //迭代列，回溯行(在没行找到了即可停止该行)，注意与L79单词搜索对比
    private void dfs(int row, int[] cols,int[] leftdown,int[] leftup){
        if (row==len){
            res++;
            return;
        }
        for (int i = 0; i < len; i++) {
            if(cols[i]+leftdown[row+i]+leftup[row-i+len-1]==0){
                cols[i]=1;
                leftdown[row+i]=1;
                leftup[row-i+len-1]=1;
                dfs(row+1,cols,leftdown,leftup);
                cols[i]=0;
                leftdown[row+i]=0;
                leftup[row-i+len-1]=0;
            }
        }
    }
}
