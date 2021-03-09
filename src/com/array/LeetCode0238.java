package com.array;
/*
    Medium
        给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/product-of-array-except-self
 */
public class LeetCode0238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return new int[0];
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++)
            left[i] = nums[i - 1] * left[i - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = nums[i + 1] * right[i + 1];
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = left[i] * right[i];
        return res;
    }
}
