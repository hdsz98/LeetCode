package com.array;

import java.util.HashMap;
import java.util.Map;

/*
    Easy
        给定一个整数数组，判断是否存在重复元素。

        如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class LeetCode0217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
