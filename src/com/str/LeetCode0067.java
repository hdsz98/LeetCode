package com.str;
/*
    Easy
        给你两个二进制字符串，返回它们的和（用二进制表示）。

        输入为 非空 字符串且只包含数字 1 和 0。
 */
public class LeetCode0067 {
    public String addBinary(String a, String b) {
        int n1 = a.length() - 1, n2 = b.length() - 1;
        int pop = 0;
        String res = "";
        while (n1 >= 0 && n2 >= 0) {
            int temp = a.charAt(n1) - '0' + b.charAt(n2) - '0' + pop;
            res = (temp % 2) + res;
            pop = temp / 2;
            n1--;
            n2--;
        }
        while (n1 >= 0) {
            int temp = a.charAt(n1) - '0' + pop;
            res = (temp % 2) + res;
            pop = temp / 2;
            n1--;
        }
        while (n2 >= 0) {
            int temp = b.charAt(n2) - '0' + pop;
            res = (temp % 2) + res;
            pop = temp / 2;
            n2--;
        }
        if (pop != 0)
            res = '1' + res;
        return res;
    }

    public static void main(String[] args) {
        String a = "1", b = "111";
        System.out.println(new LeetCode0067().addBinary(a, b));
    }
}
