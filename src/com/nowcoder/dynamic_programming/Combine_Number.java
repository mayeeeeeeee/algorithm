package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/5/10.
 * 参考https://www.cnblogs.com/xiaoxian1369/archive/2011/09/12/2174212.html
 * 1、将一个整数n划分为不大于m的划分数（有无m）：
 *  1）.若是划分多个整数可以存在相同的：
 *    dp[n][m]=dp[n][m-1]+dp[n-m][m]
 *    两种情况：划分的数中至少有一个m、划分的数中都小于m
 *  2) .若是划分多个不同的整数：
 *    dp[n][m]=dp[n][m-1]+dp[n-m][m-1]
 *
 * 2、将n划分成k个数的划分法（有无1）：
 *    dp[n][k]= dp[n-k][k]+ dp[n-1][k-1];
 *    dp[n][k]=dp[n-k][k]
 *    两种情况：
 *      k份中不包含1的分法，为保证每份都>=2，可以先拿出k个1分
 *　　 到每一份，然后再把剩下的n-k分成k份即可，分法有:dp[n-k][k]
 *      k份中至少有一份为1的分法，可以先那出一个1作为单独的1份，剩
 *    下的n-1再分成k- 1份即可，分法有：dp[n-1][k-1]
 *
 * 3、将n划分成若干奇数的划分法：
 *     f[i][j]:将i划分为j个偶数、g[i][j]:将i划分为j个奇数
 *     f[i][j] = g[i-j][j];
 *     g[i][j] = g[i-1][j-1]+f[i-j][j];
 *     对于偶数f[i][j]: （肯定不含1，即>=2）先在i中给每份一个1，问题变为将剩下的数分为j个奇数
 *     对于奇数g[i][j]:
 *       两种情况：
 *       至少有一个1，分法g[i-1][j-1]、不含1，分法f[i-j][j]
 *
 * 4、给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *  例：input : 10
 *      ouput : 36 (= 3 * 3 * 4)
 *
 * 5、给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class Combine_Number {
    public static void main(String[] args) {
        //combineNumber12();
        //combineNumber4(10);
        combineNumber4(6);
    }

    private static int combineNumber5(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    /**
     * dp[i]表示整数n分解成的最大乘积，j表示拆成的数
     *  dp[i]=Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
     *  in：10   out:36 3 4 3
     */
    private static int combineNumber4(int n) {
        int []dp=new int[n+1];
        for(int i=1;i<n+1;i++){
            dp[i]=1;
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    private static void combineNumber12() {
        int n=6,m=3,i,j;
        int[][] a = new int[n+1][m+1];//将一个整数n划分为不大于m的划分数
        int[][] b = new int[n + 1][m + 1];//3. 2. 将n划分成m个正整数之和的划分数。
        for(int k=0;k<=n;k++){
            a[k][0]=0;
            b[k][0]=0;
        }
        for(int k=0;k<=m;k++){
            a[0][k]=0;
            b[0][k]=0;
        }
        for(i=1;i<=n;i++){
            for(j=1;j<=m;j++){
                if(i<j){
                    a[i][j]=a[i][i];
                    b[i][j]=0;
                }
                else if(i==j){
                    a[i][j]=a[i][j-1]+1;
                    b[i][j]=1;
                }
                else {
                    a[i][j]=a[i-j][j]+a[i][j-1];
                    b[i][j]=b[i-1][j-1]+b[i-j][j];
                }
            }
        }
        System.out.println(a[n][m]);
        System.out.println(b[n][m]);
    }
}
