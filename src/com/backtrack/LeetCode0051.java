package com.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Hard

        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

        给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

        每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class LeetCode0051 {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> columns = new HashSet<>();
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();
    List<String> path = new ArrayList<>();
    public void backtrach (int n, int index) {
        if (index == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!(columns.contains(i) || diagonals1.contains(index - i) || diagonals2.contains(index + i))) {
                String s = build(n, i);
                path.add(s);
                columns.add(i);
                diagonals1.add(index - i);
                diagonals2.add(index + i);
                backtrach(n, index + 1);
                path.remove(path.size() - 1);
                columns.remove(i);
                diagonals1.remove(index - i);
                diagonals2.remove(index + i);
            }
        }
    }
    public String build (int n, int i) {
        String s = "";
        for (int j = 0; j < i; j++)
            s += ".";
        s += "Q";
        for (int j = i + 1; j < n; j++)
            s += ".";
        return s;
    }
    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) {
            String s = build(n, i);
            path.add(s);
            columns.add(i);
            diagonals1.add(0 - i);
            diagonals2.add(0 + i);
            backtrach(n, 1);
            path.remove(path.size() - 1);
            columns.remove(i);
            diagonals1.remove(0 - i);
            diagonals2.remove(0 + i);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = new LeetCode0051().solveNQueens(4);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.println(res.get(i).get(j));
        }
    }
}
