package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/5.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。{3,4,5,1,2}  1
 */
public class 旋转数组中的最小数字 {
    public static void main(String[] args) {
        int []a={3,4,1,2};
        System.out.println(minNumberInRotateArray(a));
    }
    public static int minNumberInRotateArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int l=0,r=nums.length-1;
        while (r-l>2) {
            int divide = (l + r) >> 1;
            if(nums[l]<=nums[divide]){
                l=divide+1;
            }
            else {
                r=divide;
            }
        }
        return nums[l]<nums[r]?nums[l]:nums[r];
    }

}
