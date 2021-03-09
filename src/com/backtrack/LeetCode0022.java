package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
    Medium
        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode0022 {
    List<String> res = new ArrayList<>();
    String path = "";
    public void backtrack(int n, int left, int right) {
        if (right > left || left > n)
            return;
        if (left == n) {
            if (left == right) {
                res.add(new String(path));
                return;
            }
            else {
                String temp = path;
                for (int i = 0; i < left - right; i++)
                    path += ")";
                res.add(new String(path));
                path = temp;
                return;
            }
        }
        path += "(";
        backtrack(n, left + 1, right);
        path = path.substring(0, path.length() - 1);
        path += ")";
        backtrack(n, left, right + 1);
        path = path.substring(0, path.length() - 1);
    }
    public List<String> generateParenthesis(int n) {
        path += "(";
        backtrack(n, 1, 0);

        return res;
    }

    public static void main(String[] args) {
        List<String> res = new LeetCode0022().generateParenthesis(3);
        for (int i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
    }
}
