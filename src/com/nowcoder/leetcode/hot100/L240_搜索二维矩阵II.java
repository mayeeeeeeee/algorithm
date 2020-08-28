package com.nowcoder.leetcode.hot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangzhiwen on 2020/2/29.
 */
public class L240_搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        //起点为最右上角的元素
        int row = 0, col = matrix[0].length - 1;
        //判断当前数组元素和target，如果当前大于target，往左走；小与target，往下走
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] < target){
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                return true;
            }
        }
        //走出边界了还没找到，说明不存在，返回false
        return false;
    }
}
