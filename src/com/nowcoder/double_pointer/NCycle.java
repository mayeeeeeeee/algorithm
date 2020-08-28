package com.nowcoder.double_pointer;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/4/10.
 * n人报数问题
 * 输入：10 3
 * 输出：3 6 9 2 7 1 8 5 10     10
 * 双指针法：i用于循环遍历，j用于计数
 */
public class NCycle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m=in.nextInt(),n=in.nextInt(),size=m,j=0,i=1;
            int a[]=new int[m+1];
            for(int k=1;k<a.length;k++){
                a[k]=0;
            }
            while (size!=1) {
                if (i > m) {//循环遍历
                    i -= m;
                }
                if (a[i] == 0) {//进行计数
                    j++;
                }
                if (j == n) {//满足条件输出重新计数
                    a[i] = 1;
                    size--;
                    System.out.print(i + " ");
                    j=0;
                }
                i++;//遍历指针
            }
            System.out.println();
            for(int k=1;k<a.length;k++){
                if(a[k]==0)
                    System.out.println(k);
            }
        }
    }
}
