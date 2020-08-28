package com.nowcoder;



import java.util.Scanner;
public class test111 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int[]a=new int[m],b=new int[m];
        for (int i = 0; i < m; i++) {
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }
        f(a,b);
    }
    public static void f(int[]a,int[]b){
        if(a==null||a.length==0){
            System.out.println("");
        }
        int max=b[0],time=a[0],count=b[0]-1;//count表示当前积压
        for (int i = 1; i < a.length; i++) {
            int diff=a[i]-a[i-1];
            if(count<diff){
                count=b[i]-1;
            }
            else {
                count=count-diff+b[i];
            }
            if(count+1>max){
                max=count+1;
            }
        }
        System.out.println(a[a.length-1]+count+1+" "+max);
    }
}
