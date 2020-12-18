package cn.hws.math.dy;

public class q6 {
    /**
     * 股票
     * leetcode 121  买卖一次
     *          122 无数次
     *          123 2次
     *          309  冷却cd
     *          188 k次
     *          714 手续费
     *
     *
     *  持有1股,买卖多次
     *   MP[i][k][j]   i => 0, n-1   k => 0, K 交易次数 j => 0,1  0未持有 1持有
     *
     *   MP[i][k][0] = Max(MP[i-1][k][0]  //不动,MP[i-1][k-1][1] + a[i] //卖了)
     *   MP[i][k][1] = Max(MP[i-1][k][1]  //不动,MP[i-1][k-1][0] - a[i] //买了)
     *
     *   最终res = max{MP[n-1,{0..k},0]}
     *
     *
     *  若可以持有多股 O(N*K*X)
     *  MP[i][k][j]   i => 0, n-1   k => 0, K 交易次数 j => 0..X 持有股数
     *
     *  for i 0 -> n-1
     *      for k 0 ->K
     *          for j 0 -> X
     *              MP[i][k][j] = Max(MP[i-1][k][j]  //不动,MP[i-1][k-1][j+1] + a[i] //卖了,MP[i-1][k-1][j-1] - a[i] //买了,)
     *
     *
     */

    /**
     * 121
     *
     * @param att
     * @return
     */
    public int maxP(int[] att) {
        int preMin = att[0];
        int resMax = 0;

        for (int i = 1; i < att.length; i++) {
            if (att[i] > preMin) {
                resMax = Math.max(resMax, att[i] - preMin);
            } else {
                preMin = att[i];
            }
        }
        return resMax;
    }

    /**
     * 买卖一次,持有一股
     */
    public int maxp2(int[] prices) {
        int[][] dp = new int[prices.length][3];

        dp[0][0] = 0; //不动
        dp[0][1] = -prices[0]; //买
        dp[0][2] = 0; //卖

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];

            res = Math.max(res, Math.max(Math.max(dp[i][0], dp[i][1]), dp[i][2]));

        }
        return res;
    }

    /**
     * 买卖二次,持有一股
     */
    public int maxp3(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = -Integer.MAX_VALUE;
        dp[0][1][1] = -Integer.MAX_VALUE;
        dp[0][2][0] = -Integer.MAX_VALUE;
        dp[0][2][1] = -Integer.MAX_VALUE;


        for (int i = 1; i < prices.length; i++) {

            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);

            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);

            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }
        int len = prices.length - 1;
        return Math.max(Math.max(dp[len][0][0], dp[len][1][0]), dp[len][2][0]);
    }

    /**
     * dp[i][j][k]
     * i: 0->n-1
     * j: 0不持有1持有2冷冻期
     * k: 0非冷却期1冷却期
     * dp[i][0]  = MAX(dp[i-1][0], dp[i-1][2])
     * dp[i][1]  = Max(dp[i-1][1],dp[i-1][0] - a[i])
     * dp[i][2]  = dp[i-1][1] + a[i]
     */

    public int mosta(int[] prices) {
        int[][] dp = new int[prices.length][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }


}
