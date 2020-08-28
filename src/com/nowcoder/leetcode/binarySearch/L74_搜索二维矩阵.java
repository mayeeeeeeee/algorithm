package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/10.
 */
public class L74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int l=0,r=matrix.length*matrix[0].length-1,mid,rows=matrix.length,cols=matrix[0].length,row,col;
        while (l<=r){
            mid=l+(r-l)/2;
            row=mid/cols;
            col=mid%cols;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        return false;
    }

}
