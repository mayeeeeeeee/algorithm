package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/5.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class 矩形覆盖 {
    public int RectCover(int target) {
        int n1=1,n2=2;
        if(target<3){
            return target;
        }
        for (int i = 3; i <=target ; i++) {
            int temp=n2;
            n2=n1+n2;
            n1=temp;
        }
        return n2;
    }
}
