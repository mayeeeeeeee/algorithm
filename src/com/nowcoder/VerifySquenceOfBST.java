package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/3/27.
 * 数组进行递归时，使用前后指针
 * 在递归出口处理临界情况
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int [] array={1,2,3,4,5};
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(array));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    public boolean VerifySquenceOfBST(int [] a,int first,int last) {
        if(first>=last){  //叶子节点==   空树>
            return true;
        }
        int root=a[last],i=first;
        for(;i<last;i++){
            if(root<a[i]){
                break;
            }
        }
       /* if(i==last){
            return VerifySquenceOfBST(a,first,i-1);
        }*/

        int j=i;
        for (;j<last;j++){
            if(root>a[j]){
                return false;
            }
        }
      /*  if(i==first){
            return VerifySquenceOfBST(a,first,last-1);
        }
        */
        return VerifySquenceOfBST(a,first,i-1)&&VerifySquenceOfBST(a,i,j-1);
    }
}
