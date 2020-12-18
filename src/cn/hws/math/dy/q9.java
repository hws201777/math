package cn.hws.math.dy;

public class q9 {
    /**
     * 编辑距离
     * leetcode 72
     * <p>
     * 1.暴力求解
     * <p>
     * 2.动态规划 O(m*n)
     * 状态 dp[i][j]
     * <p>
     * i 单词1的前i个字符
     * j 单机2的前j个字符
     * <p>
     * 单词1的前i个字符 匹配 单词2的前j个字符
     * <p>
     * dp[m][n]
     * for  i: 0 -> m
     * for  j: 0 -> n
     * dp[i,j] =  if w1[i] = w2[j]
     * dp[i-1,j-1]
     * else
     * 1 + Min(dp[i-1,j],dp[i,j-1],dp[i-1,j-1])
     */

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else { //最小
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }



}
