package com.math;
/*
    Easy
        给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class LeetCode0009 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = 0, temp = x;
        while (temp != 0) {
            y = y * 10 + temp % 10;
            temp /= 10;
        }
        return y == x;
    }
}
