package com.nowcoder;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/4/12.
 * 0 0 1 3 5
 *
 *
 *
 *
 */
public class IsContinuous {
    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        while (in.hasNext()){
//            double n=in.nextDouble();
//           // System.out.println(Math.sqrt(2*n+0.25)-0.5);
//            double temp=Math.sqrt(2*n+0.25)-0.5;
//            System.out.println(Math.ceil(temp));
//        }
        //System.out.println(Math.ceil(3.0));
        int []a={0,0,6,1,3};
        //System.out.println(isContinuous(a));
        System.out.println(isContinuous1(a));
    }
    /*
    排序 计0的个数 遍历
     */
    public static boolean isContinuous(int [] numbers) {
        if(numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int value=0,temp;
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                value++;
                continue;
            }
            temp=numbers[i];
            while ((temp+1!=numbers[i+1])&&value>0){
                temp++;
                value--;
            }
            if(temp+1!=numbers[i+1]){
                return false;
            }
        }
        return true;
    }

    /*
    满足条件 1 max - min <5(不包括0)
            2 除0外没有重复的数字(牌)
     */
    public static boolean isContinuous1(int [] numbers){
        if(numbers.length==0)
            return false;
        int max=0,min=13;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if (numbers[i]==0)
                continue;
            hm.put(numbers[i],hm.getOrDefault(numbers[i],0)+1);
            if(numbers[i]>=max){
                max = numbers[i];
            }
            if(numbers[i]<=min){
                min = numbers[i];
            }
        }
        System.out.println(max+" "+min );
        if(max-min>=5)
            return false;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if(entry.getValue()>1){
                return false;
            }
        }
        return true;
    }


}
