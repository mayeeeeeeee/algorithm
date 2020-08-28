package com.nowcoder.leetcode.sweepLine;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by wangzhiwen on 2020/2/13.
 */
public class L218_天际线问题 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<Building> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new Building(building[0], 0, building[2]));
            list.add(new Building(building[1], 1, building[2]));
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b.compareTo(a)));
        list.sort((a, b) -> (a.x - b.x));
        for (Building cur : list) {
            boolean f = false;
            if (!heap.isEmpty() && heap.peek() != cur.h) {
                f = true;
            }
            if (cur.flag == 0) {
                heap.offer(cur.h);
            }
            else {
                heap.remove(cur.h);
            }
            if (f) {
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(cur.x);
            if (!heap.isEmpty()){
                temp.add(heap.peek());
            }
            else {
                temp.add(0);
            }
            res.add(temp);
        }
        return res;
    }
}
class Building {
    int x;
    int flag;
    int h;
    Building(int x, int flag, int h) {
        this.x = x;
        this.flag = flag;
        this.h = h;
    }
}