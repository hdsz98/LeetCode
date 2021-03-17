package com.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Medium
        给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

        说明：

        拆分时可以重复使用字典中的单词。
        你可以假设字典中没有重复的单词。
 */
public class LeetCode0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (String temp : wordDict)
            set.add(temp);
        StringBuilder sb = new StringBuilder();
        int index = -1;
        int[] dp =  new int[n];
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                dp[i] = i + 1;
                index = i + 1;
                break;
            }
        }
        if (index == -1)
            return false;
        for (int i = index; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == 0)
                    continue;
                // System.out.println(s.substring(j + 1, i + 1) + "    " + s.substring(j - dp[j], i + 1));
                if (wordDict.contains(s.substring(j + 1, i + 1)))
                    dp[i] = i - j;
                else if (wordDict.contains(s.substring(j - dp[j] + 1, i + 1)))
                    dp[i] = i - (j - dp[j] + 1) + 1;
            }
        }
        return dp[n - 1] != 0;
    }

    public static void main(String[] args) {
        var dict = new ArrayList<String>();
        dict.add("leet");
        dict.add("code");
        dict.add("apple");
        dict.add("pen");
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");
        dict.add("a");
        dict.add("b");
        System.out.println(new LeetCode0139().wordBreak("a", dict));
    }
}
