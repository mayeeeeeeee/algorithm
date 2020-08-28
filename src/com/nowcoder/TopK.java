package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/4/11.
 */
public class TopK {
    public static int partion(int a[], int left, int right) {
        int temp=a[left];
        while (left<right) {
            while (temp<=a[right]&&left<right){
                right--;
            }
            a[left]=a[right];
            while (temp>=a[left]&&left<right){
                left++;
            }
            a[right]=a[left];
        }
        a[left]=temp;
        return left;
    }
    //把前k小的数放在数组开始
    public static void getTopKMinBySort(int a[], int first, int end, int k) {
        if (first < end) {
            int partionIndex = partion(a, first, end);
            if (partionIndex == k - 1) return;
            else if (partionIndex > k - 1) getTopKMinBySort(a, first, partionIndex - 1, k);
            else getTopKMinBySort(a, partionIndex + 1, end, k);
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 20, 3, 7, 9, 1, 17, 18, 0, 4};
        int k = 6;
        getTopKMinBySort(a, 0, a.length - 1, k);
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + " ");
        }
    }

}