package cn.hws.l;

public class N62 {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * <p>
     * <p>
     * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * <p>
     * <p>
     * dp[i][j]
     * <p>
     * dp[i][j] = dp[i][j+1] + dp[i+1][j]
     * <p>
     * res dp[0][0]
     */


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];

        for (int i = m - 1; i >= 0; i--) {
            dp[n - 1][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i][m - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }


}
