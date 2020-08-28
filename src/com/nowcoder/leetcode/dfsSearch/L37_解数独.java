package com.nowcoder.leetcode.dfsSearch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangzhiwen on 2019/10/28.
 */
public class L37_解数独 {
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new L37_解数独().solveSudoku(board);
    }
    private int rows,cols;

    public void solveSudoku(char[][] board) {
        rows = board.length;
        cols=board[0].length;
        boolean[][] srow=new boolean[rows][9],scol=new boolean[cols][9],st=new boolean[9][9];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j]!='.'){
                    char ch=board[i][j];
                    srow[i][ch-'0'-1]=true;
                    scol[j][ch-'0'-1]=true;
                    st[i/3*3+j/3][ch-'0'-1]=true;
                }
            }
        }
        dfs(board,0,0,srow,scol,st);
    }

    private boolean dfs(char[][] board,int i,int j, boolean[][] srow, boolean[][] scol, boolean[][] st) {
        int r=i,c=j;
        if(c==cols){
            r++;
            c=0;
        }
        if(r==rows){
            return true;
        }
        if(board[r][c]!='.'){
            return dfs(board,r,c+1,srow,scol,st);
        }
        for (int k = 1; k <=9; k++) {
            if(!srow[r][k-1]&&!scol[c][k-1]&&!st[r/3*3+c/3][k-1]){
                board[r][c]=(char)(k+'0');
                srow[r][k-1]=true;
                scol[c][k-1]=true;
                st[r/3*3+c/3][k-1]=true;
                if(dfs(board,r,c+1,srow,scol,st)){
                    return true;
                }
                else {
                    board[r][c]='.';
                    srow[r][k-1]=false;
                    scol[c][k-1]=false;
                    st[r/3*3+c/3][k-1]=false;
                }
            }
        }
        return false;
    }
}
