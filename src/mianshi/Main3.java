package mianshi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public int findCount(Map<Integer, Integer> map) {bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
    }
}
