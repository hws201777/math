package cn.hws.math.dy;

import java.util.Arrays;

public class q7 {
    /**
     * 最长上述子序列
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * leetcode 300
     * <p>
     * <p>
     * 1.递归
     * 对于第一个数,选或者不选
     * 对于第二个数,选或者不选
     * 2^n
     * <p>
     * 2.动态规划 O(N^2)
     * dp[i]
     * Max(dp[0],dp[1]....dp[n-1])
     * <p>
     * for 0 -> n-1
     * dp[i] = max(dp[j]) + 1
     * j : 0 -> i-1 且 a[j] < a[i]
     * <p>
     * 3.二分 O(NlogN)
     */


    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int res = 0;

        int[] data = new int[nums.length];
        data[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = max > data[j] ? max : data[j] + 1;
                }
            }
            data[i] = max == Integer.MIN_VALUE ? 0 : max;

            res = res > data[i] ? res : data[i] + 1;
        }
        return res;
    }

    public int lengthOfLISV2(int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
