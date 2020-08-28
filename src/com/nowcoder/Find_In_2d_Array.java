package com.nowcoder;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Find_In_2d_Array {
    public boolean find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        int rows = array.length, cols = array[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c])
                return true;
            else if (target > array[r][c])
                r++;
            else
                c--;
        }
        return false;
    }

    public static void main(String[] args) {
        Find_In_2d_Array find = new Find_In_2d_Array();
        int a[][]={{1,3,4,5,6},{2,3,4,5,6}};
        System.out.println(find.find(1,a));
    }
}

