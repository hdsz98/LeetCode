package com.array;

import com.backtrack.LeetCode0079;

/*
    Medium
        给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 */
public class LeetCode0080 {
    public int removeDuplicates(int[] nums) {
        int count = 1, flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && flag < 2) {
                nums[count++] = nums[i];
                flag++;
            }
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
                flag = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(new LeetCode0080().removeDuplicates(nums));
    }
}
