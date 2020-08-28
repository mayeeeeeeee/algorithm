package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/3.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[]a={2,3,1,0,2,5,3};
        System.out.println(f(a));
    }
    public static boolean f(int[] a){//2,3,1,0,2,5,3 不改变原数组
        if(a==null||a.length<=0){
            return false;
        }
        int []b=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int index=a[i];
            if(b[index]!=0){
                System.out.println(index);
                return true;
            }
            else {
                b[index]=a[index];
            }
        }
        return false;
    }
    public static boolean ff(int []a){//改变原数组
        if(a==null||a.length<=0){
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            int index=a[i];
            if(index<0){
                index+=a.length;
            }
            if(a[index]<0){
                System.out.println(index);
                return false;
            }
            else {
                a[index]-=a.length;
            }
        }
        return false;
    }
}
