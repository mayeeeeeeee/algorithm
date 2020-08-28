package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/5/19.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {
    public static void main(String[] args) {

    }
    /*
        桶排序的思想/哈希
     */
    public static boolean deplicate(int numbers[],int length,int [] duplication){
        int[] a = new int[length];
        int k=0;
        for(int i=0;i<length;i++){
            a[numbers[i]]++;
            if(a[numbers[i]]>1){
                duplication[k++]=numbers[i];
                return true;
            }
        }
        return false;
    }
    /*
     不需要额外的数组或者hash table来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，
     当一个数字被访问过后，可以设置对应位上的数-n（防止溢出），之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
     需要额外的空间，
     */
    public static boolean deplicate1(int numbers[],int length,int [] duplication){
        //检验原数组元素
        for(int i=0;i<length;i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }
        }
        for (int i=0;i<length;i++) {
            int index = numbers[i];
            if (index < 0) {
                index += length;
            }
            if (numbers[index] < 0) {
                duplication[0]=index;
                return true;
            }
            numbers[index]-=length;
        }
        return false;
    }
}
