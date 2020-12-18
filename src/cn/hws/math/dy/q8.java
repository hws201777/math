package cn.hws.math.dy;

public class q8 {
    /**
     * 零钱兑换 数量最少
     * leetcode 322
     * [1,2,5]  11  => 3
     * [2]       3  => 0
     * <p>
     * 1.暴力 1->11  2->5  5->2
     * <p>
     * 2.贪心 (X)
     * <p>
     * 3.动态规划(O(XxN))
     * <p>
     * 0起步,可以1,可以2,可以5, 可以有多少步?
     * <p>
     * dp[i] 上到i级最少步数
     * dp[1] = 1
     * dp[2] = 1
     * dp[5] = 1
     * <p>
     * <p>
     * dp[i] => min {dp[i-coins[j]]} +1
     * <p>
     * for i : 0 -> num-1
     * <p>
     * dp[x]
     */

    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数

        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                if (i >= coins[j]) {

                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }


}
