package com.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangzhiwen on 2019/8/8.
 * in: 1,10;32,45 集合合并
 *     78,94;5,16
 *     80,100;200,220;16,32
 * out: 1,45;78,100;200,220
 */
public class Segment_Combine {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=3,l,r;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            String in=sc.next();
            String[] strings=in.split(";");
            System.out.println("处理第"+i+"行："+in);
            for(int j=0;j<strings.length;j++){
                String[] split = strings[j].split(",");
                l=Integer.valueOf(split[0]);
                r=Integer.valueOf(split[1]);
                if(list.size()==0){
                    list.add(l);
                    list.add(r);
                }
                else{
                    int ll=-1,rr=-1;
                    for(int k=0;k<list.size();k++){
                        if(l<=list.get(k)){
                           ll=k;
                           for(int kk=k;kk<list.size();kk++){
                               if(r<list.get(kk)){
                                   rr=kk;
                                   break;
                               }
                           }
                           if(rr==-1){
                               rr=list.size();
                           }
                           break;
                        }
                    }
                    System.out.println("ll="+ll+"-----rr="+rr);
                    if(ll==-1){
                        list.add(list.size(),l);
                        list.add(list.size(),r);
                    }
                    else {
                        if(ll%2==0){
                            list.add(ll,l);
                            if(rr%2==0){
                                list.add(rr+1);

                            }
                            for(int kkk=0;kkk<rr-ll;kkk++){
                                list.remove(ll+1);
                            }
                        }
                        else {
                            if(rr%2==0){
                                list.add(rr,r);
                            }
                            for(int kkk=0;kkk<rr-ll;kkk++){
                                list.remove(ll);
                            }

                        }
                    }
                }
                for(int s=0;s<list.size();s++)
                    System.out.print(list.get(s)+"--");
                System.out.println();
            }
        }
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+"--");
        System.out.println();
        for(int i=0;i<list.size();i+=2){
                System.out.println(list.get(i)+","+list.get(i+1)+";");
        }
    }
}
