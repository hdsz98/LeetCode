package com.binary;
/*
    Medium
        编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 */
public class LeetCode0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        boolean flag = false;
        int i = 0;
        for (; i < m; i++) {
            if (target == matrix[i][n - 1])
                return true;
            if (target < matrix[i][n - 1]){
                flag = true;
                break;
            }
        }
        if (!flag)
            return false;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[i][mid] == target)
                return true;
            if (matrix[i][mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
