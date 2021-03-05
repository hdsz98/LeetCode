package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
    Medium
        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class LeetCode0077 {

    public void backtrack(int n, int k, List<List<Integer>> res, List<Integer> path, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            path.add(i);
            backtrack(n, k, res, path, i);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            path.add(i);
            backtrack(n, k, res, path, i);
            path.remove(path.size() - 1);
        }
        return res;
    }
}
