package com.str;

import java.util.HashSet;

/*
    Easy
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode0003 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), right = -1, ans = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !hashSet.contains(s.charAt(right + 1))) {
                hashSet.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(right - i + 1, ans);
        }
        return ans;
    }
}
