package com.array;
/*
    Hard
        给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 */
public class LeetCode0041 {
    public int firstMissingPositive(int[] nums) {
        int min = 0;
        int max = 0;

        int[] arr = new int[nums.length + 1];
        arr[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1) {
                if (nums[i] < arr.length) {
                    arr[nums[i]] = 1;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i:" + i + ",v:" +arr[i]);
            if (arr[i] == 0) {
                return i;
            }
        }
        return arr.length;
    }
}
