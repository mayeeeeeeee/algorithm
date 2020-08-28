package com.nowcoder.sort;

/**
 * 冒泡排序
 */
public class BuddleSort
{
    public static void main (String[] args) {
        int []a={4,7,2,3,75,32,45,74};
        BubbleSort(a);
        for (int k : a) {
            System.out.println(k);
        }
    }
    public static void BubbleSort(int []a) {
       boolean flag;
       int len=a.length,temp;
       for (int i=0;i<len;i++){
           flag=false;
           for(int j=0;j<len-1-i;j++){
               if(a[j]>a[j+1]){
                   temp=a[j];
                   a[j]=a[j+1];
                   a[j+1]=temp;
                   flag=true;
               }
           }
           if(flag==false)
               break;
       }
    }

}