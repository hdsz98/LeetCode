package com.binary;
/*
    easy
        实现 int sqrt(int x) 函数。

        计算并返回 x 的平方根，其中 x 是非负整数。

        由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/sqrtx
 */
public class LeetCode0069 {
    public int mySqrt(int x) {
        if(x == 1)
            return 1;
        int min = 0;
        int max = x;
        while(max-min>1)
        {
            int m = (max+min)/2;
            if(x/m<m)
                max = m;
            else
                min = m;
        }
        return min;
    }

    public static void main(String[] args) {
        int x = 100;
        System.out.println();
    }
}
