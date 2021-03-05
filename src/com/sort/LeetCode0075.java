package com.sort;
/*
    Medium
        给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/sort-colors
 */
public class LeetCode0075 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        int start = 0, end = n - 1;
        while (nums[start] == 0)
            start++;
        while (nums[end] == 2)
            end--;
        int index = start;
        while (index <= end) {
            if (nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[end];
                nums[end] = temp;
                end--;
            }
            else if (nums[index] == 0) {
                int temp = nums[index];
                nums[index] = nums[start];
                nums[start] = temp;
                start++;
                index++;
            }
            else
                index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        new LeetCode0075().sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
