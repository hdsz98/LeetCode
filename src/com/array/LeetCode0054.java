package com.array;

import java.util.ArrayList;
import java.util.List;

/*
    Medium
        给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class LeetCode0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, up = 0, down = m - 1;
        int count = 0;
        while (count < m * n) {
            for (int i = left; i <= right; i++){
                count++;
                res.add(matrix[up][i]);
            }
            if (count >= m * n)
                break;
            up++;
            for (int i = up; i <= down; i++) {
                count++;
                res.add(matrix[i][right]);
            }
            if (count >= m * n)
                break;
            right--;
            for (int i = right; i >= left; i--) {
                count++;
                res.add(matrix[down][i]);
            }
            if (count >= m * n)
                break;
            down--;
            for (int i = down; i >= up; i--) {
                count++;
                res.add(matrix[i][left]);
            }
            if (count >= m * n)
                break;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> res = new LeetCode0054().spiralOrder(matrix);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }
}
