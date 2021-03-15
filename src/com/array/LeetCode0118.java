package com.array;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Easy
        给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class LeetCode0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        for (int i = 0; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            if (i < 2) {
                res.add(Arrays.asList(temp));
                continue;
            }
            for (int j = 1; j < i; j++) {
                temp[j] = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
            }
            res.add(Arrays.asList(temp));
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new LeetCode0118().generate(5);

    }
}
