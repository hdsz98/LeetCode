package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
    Medium
        找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

        说明：

        所有数字都是正整数。
        解集不能包含重复的组合。 

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combination-sum-iii
 */
public class LeetCode0216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void backtrack(int k, int n, int index, int num, int sum) {
        if (num > k || sum > n)
            return;
        if (num == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < 10; i++) {
            if (sum + i > n)
                break;
            path.add(i);
            backtrack(k, n, i + 1, num + 1, sum + i);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 1; i < 10; i++) {
            path.add(i);
            backtrack(k, n, i + 1, 1, i);
            path.remove(path.size() - 1);
        }
        return res;
    }
}
