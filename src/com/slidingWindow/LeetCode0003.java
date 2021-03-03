package com.slidingWindow;

import java.util.HashMap;

/*
    Medium
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode0003 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length(), max = 0;
        if (n < 2)
            return n;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                max = map.size() > max ? map.size() : max;
                map.clear();
                map.put(s.charAt(i), i);
            }
            else
                map.put(s.charAt(i), i);
        }
        return map.size() > max ? map.size() : max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LeetCode0003().lengthOfLongestSubstring(s));
    }
}
