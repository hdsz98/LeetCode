package com.backtrack;

import javax.sound.midi.MidiFileFormat;

/*
    Medium
        给定一个二维网格和一个单词，找出该单词是否存在于网格中。

        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/word-search
 */
public class LeetCode0079 {
    public boolean ff = false;

    public void backtrack(char[][] board, String word, int index, int row, int col, int[][] flag) {
        if (ff)
            return;
        if (index == word.length()) {
            ff = true;
            return;
        }
        if (row > 0 && board[row - 1][col] == word.charAt(index) && flag[row - 1][col] == 0) {
            flag[row - 1][col] = 1;
            backtrack(board, word, index + 1, row - 1, col, flag);
        }

        if (row < board.length - 1 && board[row + 1][col] == word.charAt(index) && flag[row + 1][col] == 0) {
            flag[row + 1][col] = 1;
            backtrack(board, word, index + 1, row + 1, col, flag);
        }

        if (col > 0 && board[row][col - 1] == word.charAt(index) && flag[row][col - 1] == 0) {
            flag[row][col - 1] = 1;
            backtrack(board, word, index + 1, row, col - 1, flag);
        }

        if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(index) && flag[row][col + 1] == 0) {
            flag[row][col + 1] = 1;
            backtrack(board, word, index + 1, row, col + 1, flag);
        }
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ff)
                    return true;
                if (board[i][j] == word.charAt(0)) {
                    flag[i][j] = 1;
                    backtrack(board, word, 1, i, j, flag);
                }
            }
        }
        return ff;
    }

    public static void main(String[] args) {
        // char[][] c = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        char[][] c = {{'a'}};
        String s = "a";
        System.out.println(new LeetCode0079().exist(c, s));
    }
}
