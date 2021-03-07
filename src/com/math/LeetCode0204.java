package com.math;

import java.util.Arrays;

/*
    Easy
        统计所有小于非负整数 n 的质数的数量。
 */
public class LeetCode0204 {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (arr[i] == 1) {
                for (int j = 2 * i; j * i < n; j++)
                    arr[j] = 0;
            }
        }
        return Arrays.stream(arr).sum();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0204().countPrimes(10));
    }
}
