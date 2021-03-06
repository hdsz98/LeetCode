package com.str;

import java.util.Locale;

/*
    Easy
        给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
        说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class LeetCode0125 {
    public boolean isPalindrome(String s) {
        if (" ".equals(s))
            return true;
        int low = 0, high = s.length() - 1;
        s = s.toLowerCase();
        while (low < s.length() && high >= 0) {
            while (high >= 0 && !Character.isAlphabetic(s.charAt(high)) && !Character.isDigit(s.charAt(high)))
                high--;
            while (low < s.length() && !Character.isAlphabetic(s.charAt(low)) && !Character.isDigit(s.charAt(low)))
                low++;
            if (s.charAt(high) != s.charAt(low))
                return false;
            high--;
            low++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new LeetCode0125().isPalindrome(s));
    }
}
