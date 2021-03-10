package com.dp;
/*
    Easy
        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class LeetCode0053 {
    public int maxSubArray(int[] nums) {
        int n = nums.length, temp = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            temp = Math.max(nums[i], nums[i] + temp);
            max = Math.max(temp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new LeetCode0053().maxSubArray(nums));
    }
}
