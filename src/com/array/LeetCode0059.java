package com.array;
/*
    Medium
        给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class LeetCode0059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, down = n, left = 0, right = n, nums = 0;
        while (nums < n * n) {
            // right
            for (int i = left; i < right; i++)
                res[up][i] = ++nums;
            up += 1;
            for (int i = up; i < down; i++)
                res[i][right - 1] = ++nums;
            right--;
            for (int i = right - 1; i >= left; i--)
                res[down - 1][i] = ++nums;
            down--;
            for (int i = down - 1; i >= up; i--)
                res[i][left] = ++nums;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] res = new LeetCode0059().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
