package com.nowcoder;

import java.util.*;

/**12324232  根据每个元素不可能是主元素最终得到可能的主元素。
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 最快方法（O(n)）：
 采用阵地攻守的思想：（同时删除两个不相等的数，这个主元素不会改变。）
 第一个数字作为第一个士兵，守阵地；count = 1；
 遇到相同元素，count++;
 遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 再加一次判断，记录这个士兵的个数看是否大于数组一般即可。


 若有序，则主元素若有，一定是中间元素。
 */
public class MainElem {
    public static void main(String []args){
        int []nums={1,1,1,1,2,2,3};
        System.out.println(MoreThanHalfNum_Solution(nums));
    }
    public static int MoreThanHalfNum_Solution(int []array) {
        int half=array.length/2;
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i:array){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()>half){
                return entry.getKey();
            }
        }
        return 0;
    }
}
