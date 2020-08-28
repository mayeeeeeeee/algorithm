package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/8/11.
 */
public class ZeroOne_Package {
    public static void main(String[] args) {
        int []w={2,3,4,5};
        int []v={3,4,5,6};
        int bagv=4;
        f(v,w,bagv);
    }

    /**
     *处理第一个元素方法：
     * 1.在w,v数组前加0 ，i=1~w.length-1 dp[i]<==dp[i-1]
     * 2.dp[w.length+1][bagv], i=0~w.length dp[i+1]<==dp[i] (w[i]对应dp[i+1])
     * 3.初始化dp[0][j]
     * 出现前后两项之间的关系，会出现i+1(后面少1个)或i-1(前面多一个)
     */
    public static int f(int[] v, int[] w, int bagV) {
        int dp[][] = new int[w.length+1][bagV+1];                    //动态规划表
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <=bagV; j++) {//bagV在内
                if (j < w[i])
                    dp[i+1][j] = dp[i ][j];
                else
                    dp[i+1][j] = Math.max(dp[i ][j], dp[i][j - w[i]] + v[i]);
            }
        }

        //动态规划表的输出
        for (int i = 0; i < v.length+1; i++) {
            for (int j = 0; j < bagV+1; j++) {
                System.out.println(dp[i][j]);
            }
        }
        return 1;
    }
}

