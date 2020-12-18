package cn.hws.l;

import java.util.List;

public class N120 {
    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     *
     *
     *
     * 例如，给定三角形：
     *
     * [
     *    [2],
     *    [3,4],
     *    [6,5,7],
     *    [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     */


    public int minimumTotal(List<List<Integer>> att) {
        int[][] dp = new int[att.size()][att.get(att.size()-1).size()];

        for (int i = 0; i < att.get(att.size()-1).size(); i++) {
            dp[att.size()-1][i] = att.get(att.size()-1).get(i);
        }

        for (int i = att.size()-2; i >=0 ; i++) {
            for (int j = att.get(i).size()-1; j >=0 ; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + att.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
