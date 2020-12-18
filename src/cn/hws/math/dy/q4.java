package cn.hws.math.dy;

import java.util.List;

public class q4 {
    /**
     * leetcode 120
     * 三角形最小路径和
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * <p>
     * <p>
     * 1.递归 O(2^n)
     * 2.贪心(X)
     * 3.动态规划 O(m*n)
     * dp[i,j]
     * dp[i,j] = a[i,j] + min(dp[i+1,j] , dp[i+1,j+1])
     * <p>
     * 初始值 dp[m-1,j] = a[m-1,j]
     */

    public int shortPath(List<List<Integer>> att) {

        for (int i = att.size() - 2; i >= 0; i--) {
            for (int j = att.get(i).size() - 1; j >= 0; j--) {
                int min = att.get(i).get(j) + Math.min(att.get(i + 1).get(j), att.get(i + 1).get(j + 1));
                att.get(i).set(j, min);
            }
        }

        return att.get(0).get(0);
    }


}
