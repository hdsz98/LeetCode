package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

        在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class LeetCode0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0, flag = 0;
        List<int[]> res = new ArrayList<>();
        while (i < n) {
            if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                flag = 1;
                int left = intervals[i][0], right = newInterval[1];
                while (i < n && right >= intervals[i][0]) {
                    right = Math.max(right, intervals[i][1]);
                    i++;
                }
                res.add(new int[] {left, right});
            }
            else {
                res.add(new int[] {intervals[i][0], intervals[i][1]});
                i++;
            }
        }
        if (flag == 0)
            res.add(new int[] {newInterval[0], newInterval[1]});
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {6, 9}};
        int[] temp = {2, 5};
        int[][] res = new LeetCode0057().insert(nums, temp);
        for (int  i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(res[i][j] + " ");
            System.out.println(" ");
        }
    }
}
