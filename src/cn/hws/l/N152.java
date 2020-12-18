package cn.hws.l;

public class N152 {
    /**
     * 152. 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * dp[i][0]
     * dp[i][1]
     * <p>
     * dp[i][0] = Max(dp[i-1][0]*att[i],att[i])
     * dp[i][1] = min(dp[i-1][1]*att[i],att[i])
     */


    public int maxProduct(int[] att) {
        int res = att[0];
        int[][] dp = new int[att.length][2];

        dp[0][0] = att[0];
        dp[0][1] = att[0];

        for (int i = 1; i < att.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * att[i], dp[i - 1][1] * att[i]), att[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * att[i], dp[i - 1][1] * att[i]), att[i]);
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
}
