package com.dp;
/*
    Easy
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

        注意：给定 n 是一个正整数。
 */
public class LeetCode0070 {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int n1 = 1, n2 = 2;
        for (int i = 3; i < n + 1; i++) {
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}
