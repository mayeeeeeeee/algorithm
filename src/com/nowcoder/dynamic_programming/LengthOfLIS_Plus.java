package com.nowcoder.dynamic_programming;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by wangzhiwen on 2019/8/11.
 * 最长递增子序列
 */
public class LengthOfLIS_Plus {
    //测试数据10 4 2 3 1 5 6 4 8 5 9
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int a[]=new int[m];
        for (int i = 0; i < m; i++) {
            a[i]=scanner.nextInt();
        }
        System.out.println(solution(a));
    }
    private static int solution(int[] arr){
        int dp[] = new int[arr.length + 1];
        dp[1] = arr[0];
        int p = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= dp[p]){
                dp[++p] = arr[i];
            }else{
                //使用二分查找第一个大于arr[i]的下标
                int index = indexOfFirstBigger(0, p, dp, arr[i]);
                //进行元素的替换
                dp[index] = arr[i];
            }
        }
        return p;
    }
    //二分查找
    private static int indexOfFirstBigger(int low, int high, int dp[], int k){
        if(low >= high) return low;
        int mid = (low + high) >> 1;
        int midVal = dp[mid];
        if(low < high && midVal <= k){
            return indexOfFirstBigger(mid + 1, high, dp, k);
        }else{
            return indexOfFirstBigger(low, mid, dp, k);
        }
    }

}
