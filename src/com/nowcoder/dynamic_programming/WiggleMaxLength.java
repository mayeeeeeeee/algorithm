package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/5/27.
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。
 * 少于两个元素的序列也是摆动序列。给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，
 * 剩下的元素保持其原始顺序。
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 */
public class WiggleMaxLength {
    public static void main(String[] args) {
        int a[]={1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(a));
    }
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            //if交替执行才会增加
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
    public static int ff(int[] a) {
        if(a==null||a.length==0){
            return 0;
        }
        int dp[][] = new int[a.length][2];
        int flag=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(flag==0&&a[i]-a[j]!=0){
                    flag=1;
                    dp[0][1]=a[i]-a[j];
                }
                if((a[i]-a[j])*dp[j][1]>0){
                    dp[i][0]=Math.max(dp[j][0]+1,dp[i][0]);
                    dp[i][1]=a[j]-a[i];
                }
            }
        }
        return (dp[a.length-1][0]+1);
    }
}
