package com.greedy;
/*
    Medium
        给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个下标。
 */
public class LeetCode0055 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return true;
        int end = n - 1, index = end - 1;
        while (end >= 0 && index >= 0) {
            if (end - index <= nums[index]) {
                end = index;
                index = end - 1;
            }
            else
                index--;
        }
        return end == 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(new LeetCode0055().canJump(nums));
    }
}
