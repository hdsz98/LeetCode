package com.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Hard
        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

        给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。

 */
public class LeetCode0052 {
    public int count = 0;
    Set<Integer> columns = new HashSet<>();
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();
    public void backtrach (int n, int index) {
        if (index == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!(columns.contains(i) || diagonals1.contains(index - i) || diagonals2.contains(index + i))) {
                columns.add(i);
                diagonals1.add(index - i);
                diagonals2.add(index + i);
                backtrach(n, index + 1);
                columns.remove(i);
                diagonals1.remove(index - i);
                diagonals2.remove(index + i);
            }
        }
    }
    public int totalNQueens(int n) {
        for (int i = 0; i < n; i++) {
            columns.add(i);
            diagonals1.add(0 - i);
            diagonals2.add(0 + i);
            backtrach(n, 1);
            columns.remove(i);
            diagonals1.remove(0 - i);
            diagonals2.remove(0 + i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0052().totalNQueens(4));
    }
}
