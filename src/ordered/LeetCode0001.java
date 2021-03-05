package ordered;

import java.util.HashMap;
import java.util.Map;

/*
    Easy
        给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/two-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode0001 {
    /*
        HashMap方法
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 2)
            return new int[0];
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null && nums[i] * 2 == target){
                res[0] = i;
                res[1] = map.get(nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(target - nums[i]) != null && map.get(target - nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        // int[] nums = {3, 3};
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = new LeetCode0001().twoSum(nums, target);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}
