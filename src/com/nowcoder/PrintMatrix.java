package com.nowcoder;
import java.util.ArrayList;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字.
 * 例如，如果输入如下4X4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public static void main(String[] args) {
        int [][]a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        System.out.println(printMatrix(a));

    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res=new ArrayList<>();
        if(matrix==null)
        {
            return null;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(rows==0&&cols==0) {
            return null;
        }
        int left=0,top=0,right=cols-1,bottom=rows-1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++) {
                res.add(matrix[top][i]);
            }
            for(int j=top+1;j<=bottom;j++){
                res.add(matrix[right][j]);
            }
            for(int k=right-1;k>=left&&top!=bottom;k--){
                res.add(matrix[bottom][k]);
            }
            for(int h=bottom-1;h>top&&left!=right;h--){
                res.add(matrix[left][h]);
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
