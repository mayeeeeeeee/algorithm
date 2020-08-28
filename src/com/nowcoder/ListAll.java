package com.nowcoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by wangzhiwen on 2019/2/21.
 * 把一个数组里的数组合全部列出，比如1和2列出来为1，2，12，21。
 */
public class ListAll {
    public static void main(String[] args) {
        String[] str = new String[]{"2", "1", "3", "4"};
        listAll(Arrays.asList(str), "");
    }

    public static void listAll(List base, String prefix) {
  //      if (base.isEmpty())  //这儿体现了递归的出口
            System.out.println(prefix);
        for (int i = 0; i < base.size(); i++) {
            List temp = new LinkedList(base);
            listAll(temp, prefix + temp.remove(i));//切分
        }
    }
}
