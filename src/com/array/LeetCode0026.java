package com.array;
/*
    easy
        给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
public class LeetCode0026 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1])
                nums[count++] = nums[i];
        }
        return count;
    }
}
