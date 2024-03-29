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
    List<List<Integer>> res = new ArrayList<>();
    public void twoSum(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(0 - target);
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left])
                    left++;
                while (right > left && nums[right + 1] == nums[right])
                    right--;
            }
            else if (nums[left] + nums[right] > target)
                right--;
            else
                left++;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        if (n < 3)
            return res;
        Arrays.sort(nums);
        if (nums[0] > 0)
            return res;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                twoSum(nums, target, i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        // int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new LeetCode0015().threeSum(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println(" ");
        }
    }
}
