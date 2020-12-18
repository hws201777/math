package cn.hws.l;

public class N70 {
    public static int climbStairs(int n) {
        return n <= 1 ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }


    public static int climbStairsV2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbStairsV2(n));
    }


}
