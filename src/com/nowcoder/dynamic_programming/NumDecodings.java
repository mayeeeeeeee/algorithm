package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/5/25.
 * 1-26对应编码A-Z
 * input 数字字符串
 * output 编码个数
 * 如 i：26 o：2(2,6、26)
 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
    public static int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        if(s.charAt(0)-'0'==0)
            return 0;
        int len=s.length();
        int []dp=new int[len+1];
        dp[0]=1;//dp[i]为下标i以及之前的字符串的解码数
        dp[1]=1;
        for(int i=2;i<len+1;i++){
            if(s.charAt(i-1)-'0'+(s.charAt(i-2)-'0')*10<=26)
                dp[i]=dp[i-1]+dp[i-2];
            else dp[i]=dp[i-1];
            if(s.charAt(i-1)-'0'==0){
                if(s.charAt(i-2)-'0'>0&&s.charAt(i-2)-'0'<=2)
                {
                    dp[i]=dp[i-2];
                }
                else
                    return 0;
            }
        }
        return dp[len];
     }
    //令解
    public static int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
