package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
    Medium
        给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class LeetCode0046 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();
    public int[] flag = null;

    public void backtrack (int[] nums, int sum) {
        if (sum == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] != 1) {
                path.add(nums[i]);
                flag[i] = 1;
                backtrack(nums, sum + 1);
                path.remove(path.size() - 1);
                flag[i] = 0;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        flag = new int[n];
        for (int i = 0; i < n; i++) {
            path.add(nums[i]);
            flag[i] = 1;
            backtrack(nums, 1);
            path.remove(path.size() - 1);
            flag[i] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new LeetCode0046().permute(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
