package ordered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
        candidates 中的每个数字在每个组合中只能使用一次。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class LeetCode0040 {
    public void backtrack (int[] candidates, int target, int index, int sum, List<List<Integer>> res, List<Integer> path) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target)
            return;
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (sum > target)
                break;
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i + 1, sum, res, path);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, 0, 0, res, path);
        return res;
    }
}
