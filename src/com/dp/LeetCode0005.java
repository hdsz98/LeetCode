package com.dp;
/*
    Medium
        给你一个字符串 s，找到 s 中最长的回文子串。

    中心扩展法
 */
public class LeetCode0005 {
    public String longestPalindrome(String s) {
        if (s.length() == 1 || s == null)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public int expand (String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
