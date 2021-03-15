package com.array;

import java.util.ArrayList;
import java.util.List;
/*
    Easy
        给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
 */
public class LeetCode0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
}
