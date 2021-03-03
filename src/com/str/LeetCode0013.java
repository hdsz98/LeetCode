package com.str;

import java.util.HashMap;
import java.util.Map;

/*
    Easy
        罗马数字转整数
 */
public class LeetCode0013 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int res = 0, i = 0;
        while (i < s.length()) {

            if (i < s.length() - 1 && map.containsKey(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)))) {
                res += map.get(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)));
                i++;
            }
            else
                res += map.get(String.valueOf(s.charAt(i)));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "IV";
        System.out.println(new LeetCode0013().romanToInt(s));
    }
}
