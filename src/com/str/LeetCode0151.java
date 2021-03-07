package com.str;
/*
    Medium
        给定一个字符串，逐个翻转字符串中的每个单词。

        说明：

        无空格字符构成一个 单词 。
        输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 */
public class LeetCode0151 {
    public String reverseWords(String s) {
        int index = s.length() - 1, start = index;
        String res = "";
        while (index >= 0) {
            while (start >= 0 && s.charAt(start) == ' ')
                start--;
            index = start - 1;
            while (index >= 0 && s.charAt(index) != ' ')
                index--;
            if (index < -1)
                break;
            res += s.substring(index + 1, start + 1) + " ";
            start = index - 1;
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new LeetCode0151().reverseWords(s));
    }
}
