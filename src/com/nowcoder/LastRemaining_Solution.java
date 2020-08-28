package com.nowcoder;

import java.security.acl.LastOwnerException;
import java.util.LinkedList;

/**
 * Created by wangzhiwen on 2019/5/20.
 * 约瑟夫环
 * 先加初始值提前1
 */
public class LastRemaining_Solution {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(2, 3));
    }
    //数组模拟
    public static int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if(i>=n) i=0;  //模拟环。
            if(array[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if(step==m) {               //找到待删除的对象。
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }
    //链表模拟
    public static int LastRemaining_Solution1(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

    /*
        令f[i]表示i个人玩游戏报m退出最后胜利者的编号，最后的结果自然是f[n]。
        递推公式
        f[1]=0;
        f[i]=(f[i-1]+m)%i;  (i>1)
    */
    public static int LastRemaining_Solution2(int n, int m)
    {
        if(n==0)
            return -1;
        if(n==1)
            return 0;
        else
            return (LastRemaining_Solution(n-1,m)+m)%n;
    }
}
