package com.str;
/*
    Easy
        给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。

        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/length-of-last-word
 */

public class LeetCode0058 {
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        while (n >= 0) {
            if (s.charAt(n) == ' ')
                n--;
            else
                break;
        }
        int start = n;
        while (n >= 0) {
            if (Character.isAlphabetic(s.charAt(n)))
                n--;
            else
                return start - n;
        }
        return start - n;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(new LeetCode0058().lengthOfLastWord(s));
    }
}
