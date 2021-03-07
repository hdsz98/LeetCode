package com.binary;
/*
    Medium
        假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。

        请找出其中最小的元素。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 */
public class LeetCode0153 {
    public int findMin(int[] nums) {
        int high = nums.length - 1, low = 0;
        while (low < high) {
            int mid = (high - low) / 2 + 1;
            if (nums[mid] < nums[high])
                high = mid;
            else
                low = mid + 1;
        }
        return nums[low];
    }
}
