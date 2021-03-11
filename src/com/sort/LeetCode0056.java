package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class LeetCode0056 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2)
            return intervals;
        Arrays.sort(intervals, (n1, n2) -> {return n1[0] - n2[0];});
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int left = intervals[i][0], right = intervals[i][1];
            while (i < n - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[] {left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);

    }
}
