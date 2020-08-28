package com.nowcoder.leetcode.string;

/**
 * Created by wangzhiwen on 2019/10/17.
 */
public class L165_比较版本号 {
    public static void main(String[] args) {
        System.out.println(new L165_比较版本号().compareVersion("01", "1"));
    }
    public int compareVersion(String version1, String version2) {
        int l1=0,l2=0;
        while (l1<version1.length()||l2<version2.length()){
            long a1=0,a2=0;
            int ll1=l1,ll2=l2;
            while (ll1<version1.length()&&version1.charAt(ll1)!='.'){
                a1+=10*a1+version1.charAt(ll1)-'0';
                ll1++;
                l1=ll1+1;
            }
            while (ll2<version2.length()&&version2.charAt(ll2)!='.'){
                a2+=10*a2+version2.charAt(ll2)-'0';
                ll2++;
                l2=ll2+1;
            }
            if(a1>a2){
                return 1;
            }
            else if(a1<a2){
                return -1;
            }
        }
        return 0;
    }
}
