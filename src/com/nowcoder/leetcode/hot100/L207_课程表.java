package com.nowcoder.leetcode.hot100;

import java.util.LinkedList;

/**
 * Created by wangzhiwen on 2020/2/22.
 */
/*课程安排图是否是有向无环图(DAG) <==> 是否存在拓扑排序 */
public class L207_课程表 {
    //bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for(int[] cp : prerequisites) indegrees[cp[0]]++;//统计所有点的入度 indegrees[i] = i点的入度
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) queue.addLast(i); //找到入度为0的点
        }
        while(!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] req : prerequisites) {//遍历边，处理点
                if(req[1] != pre) continue;
                if(--indegrees[req[0]] == 0) queue.add(req[0]);
            }
        }
        return numCourses == 0;
    }

}
