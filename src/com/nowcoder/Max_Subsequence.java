package com.nowcoder;

import java.util.Stack;

/**
 * 最大连续子序列
 * 输入：【6, -3, -2, 7, -15, 1, 2, 2】
 * 输出：8
 *
 *使用动态规划
 *F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
 *F（i）=max（F（i-1）+array[i] ， array[i]）
 *res：所有子数组的和的最大值
 *res=max（res，F（i））
 *
 * 对于当前访问到的元素，以它为尾的子序列有两种情况，加之前最大，与不加只保留当前元素。
 * 遍历一遍得所有情况，最大在其中，则记录即可。
 *
 */
public class Max_Subsequence {
    public static void main(String[] args) {
        int []array={6,-3,-2,7,-15,1,2,2};
        System.out.println(IsTrue(array));
    }
    public static int IsTrue(int []array){
        //int []a=new int[array.length];
        if(array==null){
            return 0;
        }
        int max=array[0];
        int res=array[0];


        for (int i=1;i<array.length;i++){
            max=Math.max(max+array[i],array[i]);
            res=Math.max(res,max);
        }
        return res;
    }
}
