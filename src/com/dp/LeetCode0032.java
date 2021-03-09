package com.dp;
/*
    Hard
        给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LeetCode0032 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2)
            return 0;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (pre > 0)
                        dp[i] += dp[pre - 1];
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()()))))()()(";
        System.out.println(new LeetCode0032().longestValidParentheses(s));
    }
}
