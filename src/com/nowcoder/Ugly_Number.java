package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/5/20.
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Ugly_Number {
    public static void main(String[] args) {
        ugly_Number(10);
    }
    public static int ugly_Number(int index){
        int i2=0,i3=0,i5=0;
        int []a=new int[index];
        a[0]=1;
        for(int i=1;i<index;i++){
            a[i]=Math.min(Math.min(a[i2]*2,a[i3]*3),a[i5]*5);
            if(a[i]==a[i2]*2){
                i2++;
            }
            //不需要加else，加了会出现重复，如2*3，3*2出现2次
            if(a[i]==a[i3]*3){
                i3++;
            }
            if(a[i]==a[i5]*5){
                i5++;
            }
            System.out.println(a[i]);
        }
        return a[index-1];
    }
}
