package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
    Medium
        给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
        candidates 中的数字可以无限制重复被选取。
 */
public class LeetCode0039 {
    public void backTrack(int[] candidates, int target, int index, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target)
            return;
        for (int i = index; i < candidates.length; i++) {
            if (sum > target)
                break;
            temp.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i, sum, res, temp);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(candidates, target,  0, 0, res, temp);

        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = new LeetCode0039().combinationSum(candidates, target);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
