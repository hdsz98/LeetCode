package com.greedy;
/*
    Medium
        在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

        如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/gas-station
 */
public class LeetCode0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1, n = gas.length, flag = 1;
        while (start < n) {
            int temp = start;
            for (int i = start + 1; i < n; i++) {
                if (gas[i] >= cost[i]) {
                    start = i;
                    break;
                }
            }
            if (start == temp)
                return -1;
            int oil = gas[start] - cost[start], index = (start + 1 ) % n;
            while (index != start) {
                flag = 1;
                oil += gas[index];
                if (oil < cost[index]) {
                    flag = 0;
                    break;
                }
                else {
                    oil -= cost[index];
                    index = (index + 1) % n;
                }
            }
            if (flag != 0)
                return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {5,1,2,3,4}, cost = {4,4,1,5,1};
        System.out.println(new LeetCode0134().canCompleteCircuit(gas, cost));
    }
}
