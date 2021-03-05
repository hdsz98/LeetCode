package com.backtrack;

import java.util.ArrayList;
import java.util.List;
/*
    Medium
        给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class LeetCode0078 {

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int index) {
        res.add(new ArrayList<>(path));
        for (int i = index + 1; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, res, path, i);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        res.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, res, path, i);
            path.remove(path.size() - 1);
        }
        return res;
    }
}
