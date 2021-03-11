package com.str;

import java.util.HashSet;
import java.util.Set;

/*
    Medium
        给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

        整数除法仅保留整数部分。
 */
public class LeetCode0227 {
    public int[] getNumber (String s, int index) {
        int temp = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            temp = temp * 10 + Integer.parseInt(String.valueOf(s.charAt(index)));
            index++;
        }
        return new int[] {temp, index};
    }
    public int getFlag (String s, int index) {
        if (index >= s.length())
            return -1;
        if (s.charAt(index) == '+')
            return 0;
        else if (s.charAt(index) == '-')
            return 1;
        else if (s.charAt(index) == '*')
            return 2;
        return 3;
    }
    public int calculate (int res, int temp, int flag) {
        if (flag == 0)
            res += temp;
        else if (flag == 1)
            res -= temp;
        else if (flag == 2)
            res *= temp;
        else
            res /= temp;
        return res;
    }
    public int calculate(String s) {
        int res = 0, temp = 0;
        int index = 0, flag = 0;
        s = s.replace(" ", "");
        int n = s.length();
        while (index < n) {
            int[] i = getNumber(s, index);
            temp = i[0];
            index = i[1];
            if (index >= n) {
                res = calculate(res, temp, flag);
                return res;
            }
            if (s.charAt(index) == '+') {
                res = calculate(res, temp, flag);
                flag = 0;
                index++;
            }
            else if (s.charAt(index) == '-'){
                res = calculate(res, temp, flag);
                flag = 1;
                index++;
            }
            else {
                int flag2 = getFlag(s, index);
                index++;
                int number = 0;
                while (index < n && (flag2 == 2 || flag2 == 3)) {
                    i = getNumber(s, index);
                    number = i[0];
                    index = i[1];
                    temp = calculate(temp, number, flag2);
                    flag2 = getFlag(s, index);
                    index++;
                }
                res = calculate(res, temp, flag);
                flag = flag2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3+5/2";
        System.out.println(s.replace(" ", ""));
        System.out.println(new LeetCode0227().calculate(s));
    }
}
