package com.backtrack;
/*
    Hard
        给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。

        按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        给定 n 和 k，返回第 k 个排列。
*/
public class LeetCode0060 {
    public int count = 0;
    public String res = "";
    public int[] flag;
    public void backtrack(int n, int k, int sum, String temp) {
        if (count == k)
            return;
        if (sum == n) {
            res = new String(temp);
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                if (count == k)
                    break;
                flag[i] = 1;
                temp += String.valueOf(i + 1);
                backtrack(n, k, sum + 1, temp);
                temp = temp.substring(0, temp.length() - 1);
                flag[i] = 0;
            }
        }
    }
    public String getPermutation(int n, int k) {
        flag = new int[n];
        String temp = "";
        for (int i = 0; i < n; i++) {
            if (count == k)
                break;
            flag[i] = 1;
            temp += String.valueOf(i + 1);
            backtrack(n, k, 1, temp);
            temp = "";
            flag[i] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0060().getPermutation(3, 1));;
    }
}
