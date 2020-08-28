package com.nowcoder.sort;

/**
 * Created by wangzhiwen on 2019/3/31.
 * 插入排序
 * i=0~n-1
 * <-i+1
 * 6,4,9,1,3,5
 */


public class Insertion_sorting {
    //通过交换进行插入排序，借鉴冒泡排序:从后往前找，不断交换找到插入位置,冒泡插入法
    public static void insertionSort1(int[] a) {
        for (int i = 1; i < a.length; i++) {//无序
            for (int j = i ; j > 0&&a[j] < a[j - 1]; j--) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
            }
        }
    }

    //通过将较大的元素都向右移动而不总是交换两个元素
    public static void insertionSort2(int[] A) {
        for(int i = 1; i < A.length; i++){
            int temp = A[i],j;
            for(j = i; j > 0 && A[j - 1] > temp; j-- ){
                A[j] = A[j - 1];
            }
            A[j] = temp;
        }
    }

    //希尔排序
    public static void shellSort(int[] a) {
        // 设置步长，默认为数组长度的一半
        int step = a.length / 2;
        while (step >= 1) {
            for (int i = step; i < a.length; i++) {
                int tmp = a[i], j;
                for (j = i; j > 0 && a[j - step] > tmp; j -= step) {
                    a[j] = a[j - step];//元素后移
                }
                a[j] = tmp;//插入的位置，注意此时j在for循环中已经进行了一次--
            }
            step /= 2;
        }
    }

    public static void main(String[] args) {
        int []a={6,4,9,1,3,5};
        insertionSort1(a);
        //insertionSort2(a);
        for (int i :
                a) {
            System.out.print(i);
        }
    }
}
