package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

        说明：解集不能包含重复的子集。
 */
public class LeetCode0090 {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(path));
        for (int i = index + 1; i < nums.length; i++) {
            if (i > index + 1 && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backtrack(nums, i);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backtrack(nums, i);
            path.remove(path.size() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> res = new LeetCode0090().subsetsWithDup(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println(" ");
        }
    }
}
