package com.bitwiseOperation;
/*
    Easy
        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class LeetCode0136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res = res ^ nums[i];
        return res;
    }
}
