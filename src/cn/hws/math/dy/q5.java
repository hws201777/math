package cn.hws.math.dy;

public class q5 {
    /**
     * leetcode 152
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * <p>
     * <p>
     * 1.递归 O(2^n)
     * 2.动态规划
     * dp[i][2]  0-max 1-负max
     * <p>
     * dp[i][0]
     * dp[i][1]
     * max(dp(n),dp(n-1),dp(n-2)....)
     */

    public int maxP(int[] att) {
        int[][] dp = new int[att.length][2];

        dp[0][0] = att[0];
        dp[0][1] = att[0];
        int res = 0;
        for (int i = 1; i < att.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * att[i], dp[i - 1][1] * att[i]), att[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * att[i], dp[i - 1][1] * att[i]), att[i]);
            res = Math.max(dp[i][0], res);
        }
        return res;
    }

    public int maxPV2(int[] att) {
        int[][] dp = new int[att.length][2];
        dp[0][0] = att[0];
        dp[0][1] = att[0];
        int res = 0;
        for (int i = 0; i < att.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * att[i], dp[i - 1][1] * att[i]), att[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * att[i], dp[i - 1][1] * att[i]), att[i]);
            Math.max(res,dp[i][0]);
        }
        return res;
    }


}
