package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class LeetCode0047 {
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
                if (i > 0 && flag[i - 1] == 0 && nums[i] == nums[i - 1])
                    continue;
                path.add(nums[i]);
                flag[i] = 1;
                backtrack(nums, sum + 1);
                path.remove(path.size() - 1);
                flag[i] = 0;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        flag = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                path.add(nums[i]);
                flag[i] = 1;
                backtrack(nums, 1);
                path.remove(path.size() - 1);
                flag[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new LeetCode0047().permuteUnique(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
