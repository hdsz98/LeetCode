package com.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

        注意：答案中不可以包含重复的三元组。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/3sum
 */
public class LeetCode0015 {
    public int binaryFind (int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3)
            return res;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = n - 1;

    }
}
