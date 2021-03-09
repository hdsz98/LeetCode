package com.twoPointers;
/*
    Medium
        给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

        说明：你不能倾斜容器。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class LeetCode0011 {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right]) {
                int temp = left + 1;
                while (temp < right && height[left] > height[temp])
                    temp++;
                left = temp;
            }
            else {
                int temp = right - 1;
                while (temp > left && height[temp] < height[right])
                    temp--;
                right = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new LeetCode0011().maxArea(height));
    }
}
