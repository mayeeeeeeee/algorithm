package com.nowcoder.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wangzhiwen on 2020/2/13.
 */
public class L56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 ) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > r) {
                res.add(new int[]{l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            }
            else if (intervals[i][1] > r){
                r = intervals[i][1];
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[res.size()][]);
    }
}
