package com.binary;
/*
    Medium
        假设按照升序排序的数组在预先未知的某个点上进行了旋转。
        ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

    二分法：
        每次二分，左半部分和右半部分至少有一边是有序的。以此分为两种情况：
            1. 左半部分有序
                a. target在左边
                b. otherwiseotherwise
            2. 右半部分有序：
                a. target在右边
                b. otherwise
 */
public class LeetCode0081 {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            while (low < high && nums[low] == nums[low + 1]) low++;
            while (low < high && nums[high] == nums[high - 1]) high--;
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            // 左半部分有序
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low])
                    high = mid - 1; // target在左边
                else
                    low = mid + 1;
            }
            // 右半部分有序
            else {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(new LeetCode0081().search(nums, 3));
    }
}
