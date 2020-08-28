package com.nowcoder.sort;

/**
 * Created by wangzhiwen on 2019/3/31.
 * 选择排序
 */
public class SelectionSort {
    //简单选择
    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {//找多少次
            int index = i;
            int j;
            // 找出最小值得元素下标
            for (j = i + 1; j < A.length; j++) {
                if (A[j] < A[index]) {
                    index = j;
                }
            }
            int tmp = A[index];
            A[index] = A[i];
            A[i] = tmp;
        }
    }



}
