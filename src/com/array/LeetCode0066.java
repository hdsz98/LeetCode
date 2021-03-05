package com.array;
/*
    Easy
        给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/plus-one
 */
public class LeetCode0066 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10)
                return digits;
            else
                digits[i] %= 10;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int[] res = new LeetCode0066().plusOne(nums);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
