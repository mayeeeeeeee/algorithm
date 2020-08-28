package com.nowcoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
public class test11 {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int m=scanner.nextInt();
//        int n=scanner.nextInt();
//        String str=scanner.next();
//        List<Integer> list=new ArrayList<>();
//        String[] split = str.split("#");
//        int[] a=new int[split.length],b=new int[split.length],c=new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            String[] split1 = split[i].split(",");
//            a[i]=Integer.valueOf(split1[0]);
//            b[i]=Integer.valueOf(split1[1]);
//            c[i]=Integer.valueOf(split1[2]);
//        }
//        System.out.println(f(m,n,a,b,c));
        int []w={2,3,4,5};
        int []v={3,4,5,6};
        int bagv=8;
        System.out.println(knapsackProblemOptimized(bagv,v,w));
    }
    public static int f(int v, int k,int[] c, int[] d,int[] w){//c=a ,d=b,w=c
        int n = c.length;
        int[][] dp = new int[v+1][k+1];
        // 初始化dp，其表示前0个物品放入不同容量的背包，产生的最大价值均为0
        for(int i = 0; i <= v; i++)
            for(int j=0;j<=k;j++){
                dp[i][j] = 0;
        }
        // 更新dp值
        for(int i = 1; i <= n; i++)
            for(int j = v,x=k; j >= c[i-1]&&x>=d[i-1]; j--,x--)
                dp[j][x] = Math.max(dp[j][x], dp[j-c[i-1]][x-d[i-1]]+w[i-1]); // (2)
        return dp[v][k];
    }
    public static int dp(int weight, int count, int[] weights, int[] costs) {
        int[] preLine = new int[weight + 1];
        int[] curLine = new int[weight + 1];

        // 先处理第一行
        for (int i = 0; i <= weight; i++)
            if (weights[0] <= i)
                preLine[i] = costs[0];

        // 基于上一行处理当前行，然后迭代，pre变cur
        for (int i = 1; i < count; i++) {
            for (int j = 0; j <= weight; j++)
                if (weights[i] <= j)
                    curLine[j] = Math.max(preLine[j], costs[i] + preLine[j - weights[i]]);
                else
                    curLine[j] = preLine[j];
            preLine = curLine.clone();
        }
        return curLine[curLine.length - 1];
    }
    public static int knapsackProblemOptimized(int v, int[] c, int[] w){
        int n = c.length;
        int[] dp = new int[v+1];
        // 初始化dp，其表示前0个物品放入不同容量的背包，产生的最大价值均为0
        for(int i = 0; i <= v; i++)
            dp[i] = 0;
        // 更新dp值
        for(int i = 1; i <= n; i++)
            for(int j = v; j >= c[i-1]; j--) // （1）
                dp[j] = Math.max(dp[j], dp[j-c[i-1]]+w[i-1]); // (2)
        return dp[v];
    }



}