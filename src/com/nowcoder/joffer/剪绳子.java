package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/6.
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 8-->18
 */
public class 剪绳子 {
    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }
    public static int cutRope(int target) {
        int[] dp=new int[target+1];
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <i; j++) {
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),dp[j]*(i-j)));
                System.out.print(dp[i]+" ");
            }
            System.out.println();
        }
        return dp[target];
    }
}
