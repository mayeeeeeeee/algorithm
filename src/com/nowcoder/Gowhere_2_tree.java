package com.nowcoder;

import java.util.Scanner;

/**
 * Created by wangzhiwen on 2019/9/12.
 */
public class Gowhere_2_tree {
    public static void main(String[] args) {
        //char[]mid={'d','g','b','a','e','c','h','f' },after={'g','b','d','e','h','f','c','a'};
        Scanner scanner=new Scanner(System.in);
        char[] mid = scanner.next().toCharArray();
        char[] after=scanner.next().toCharArray();
        f(mid,0,mid.length-1,after,after.length-1);
    }
    public static void f(char[]mid,int ml,int mr,char[]after,int r){
        char root=after[r];
        System.out.print(root);
        int mmid=findmid(mid,root);
        int lnextr=findafter(mid,ml,mmid-1,after,r);
        int rnextr=findafter(mid,mmid+1,mr,after,r);
        if(lnextr!=-1){
            f(mid,ml,mmid-1,after,lnextr);
        }
        if(rnextr!=-1){
            f(mid,mmid+1,mr,after,rnextr);
        }
    }
    public static int findmid(char[] a,char ch){
        for (int i = 0; i < a.length; i++) {
            if(ch==a[i]){
                return i;
            }
        }
        return -1;
    }
    public static int findafter(char[] a,int al,int ar,char[]b,int r){
        if(al<0||ar>=a.length){
            return -1;
        }
        for (int i = r; i >=0; i--) {
            for (int j = al; j <=ar ; j++) {
                if(b[i]==a[j]){
                    return i;
                }
            }
        }
        return -1;
    }

}
