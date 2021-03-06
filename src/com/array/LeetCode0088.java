package com.array;
/*
    Easy
        给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

        初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/merge-sorted-array

    从后向前遍历
 */
public class LeetCode0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, count = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])
                nums1[count--] = nums1[i--];
            else
                nums1[count--] = nums2[j--];
        }
        while (j >= 0)
            nums1[count--] = nums2[j--];
    }
}
