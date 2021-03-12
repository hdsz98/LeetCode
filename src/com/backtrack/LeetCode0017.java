package com.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Medium
        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LeetCode0017 {
    List<String> res = new ArrayList<>();
    String path = "";
    Map<Character, String> map = new HashMap<>();
    public void backtrack (String digits, int index) {
        if (index == digits.length()) {
            res.add(new String(path));
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            path += s.charAt(i);
            backtrack(digits, index + 1);
            path = path.substring(0, path.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0)
            return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        String s = map.get(digits.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            path += s.charAt(i);
            backtrack(digits, 1);
            path = "";
        }
        return res;
    }

    public static void main(String[] args) {
        String dig = "23";
        List<String> res = new LeetCode0017().letterCombinations(dig);
        for (int i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
    }
}
