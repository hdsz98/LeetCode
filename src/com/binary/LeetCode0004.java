package com.binary;
/*
    Hard
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class LeetCode0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        double median = 0;
        if (n % 2 == 1) {
            int mid = n / 2;
            median = getKthElement(nums1, nums2, mid + 1);
        }
        else {
            int mid = n / 2 - 1, mid2 = n / 2;
            median = (getKthElement(nums1, nums2, mid + 1) + getKthElement(nums1, nums2, mid2 + 1)) / 2.0;
        }
        return median;
    }
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;
        while (true) {
            // 边界
            if (index1 == n1)
                return nums2[index2 + k - 1];
            if (index2 == n2)
                return nums1[index1 + k - 1];
            if (k == 1)
                return Math.min(nums1[index1], nums2[index2]);

            // 正常
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, n1) - 1, newIndex2 = Math.min(index2 + half, n2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
            else {
                k-= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
