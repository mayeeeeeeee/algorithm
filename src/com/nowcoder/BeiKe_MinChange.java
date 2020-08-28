package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/8/11.
 * 5 1 6 8 2 4 5 10
 * 5 (1 2 4 5 10)
 */
public class BeiKe_MinChange {
    public static void main(String[] args) {
        int []a={1,4,3,2,5};
        System.out.println(f(a));
    }
    public static int f(int []a){
        int minres=9999;//最小的结果
        for (int i = 1; i <a.length-1; i++) {
            int maxadd=0,max=0;//
            for (int j = 0; j < a.length; j++) {
                int temp=Math.abs(j-i)+a[j]-a[i];
                if(temp>max){
                   max=temp;
                }
            }
            int []b=a.clone();
            maxadd+=max;
            int l=1,r=b.length-2;
            while (l<i||r>i){
                if(b[l]<=b[l-1]&&l<i){
                    int temp=b[l-1]-b[l]+1;
                    b[l]+=temp;
                    maxadd+=temp;
                    l++;
                }
                else if(l<i){
                    l++;
                }
                if(b[r]<=b[r+1]&&r>i){
                    int temp=b[r+1]-b[r]+1;
                    b[r]+=temp;
                    maxadd+=temp;
                    r--;
                }
                else if(r>i){
                    r--;
                }
            }
            System.out.println(max+" "+maxadd);
            if(maxadd<minres){
                minres=maxadd;
            }
        }
        return minres;
    }
}
