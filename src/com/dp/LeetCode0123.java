package com.dp;
/*
    Hard
        给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

        设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    dp1[i] = max(dp[i-1], prices[i] - minval) 从前往后遍历，表示第1天到第i天之间的最大利润（通过是否在第i天卖出确认）；
    dp2[i] = max(dp[i+1], maxval - prices[i]) 从后往前遍历，表示第i天到最后一天之间的最大利润（通过是否在第i天买进确认）；
    res = max(dp1 + dp2)，(dp1 + dp2)[i] 正好表示从第1天到最后一天经过两次交易的最大利润，我们的目标是找到令总利润最大的i。
python：
 */

public class LeetCode0123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[] dp1 = new int[n], dp2 = new int[n];
        int min = prices[0], max = prices[n - 1];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        max = dp1[0] + dp2[0];
        for (int i = 1; i < n; i++){
            if (dp1[i] + dp2[i] > max)
                max = dp1[i] + dp2[i];
        }
        return max;
    }
}
