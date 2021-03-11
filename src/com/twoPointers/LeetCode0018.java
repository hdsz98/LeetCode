package com.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

        注意：答案中不可以包含重复的四元组。
 */
public class LeetCode0018 {
    List<List<Integer>> res = new ArrayList<>();
    public void twoSum(int[] nums, int first, int second, int target, int left) {
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(first);
                temp.add(second);
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
    public void threeSum(int[] nums, int first, int target, int left) {
        int n = nums.length;
        for (int i = left; i < n - 2; i++) {
            if (nums[left] > 0 && nums[left] + first > target)
                break;
            if (i == left || (i > left && nums[i] != nums[i - 1])) {
                twoSum(nums, first, nums[i], target - nums[i], i + 1);
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 3)
            return res;
        Arrays.sort(nums);
        if (nums[0] > 0 && nums[0] > target)
            return res;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] > 0 && nums[i] > target)
                break;
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1]))
                threeSum(nums, nums[i], target - nums[i], i + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,0,-1,0,-2,2};
        // int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new LeetCode0018().fourSum(nums, 0);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println(" ");
        }
    }
}
