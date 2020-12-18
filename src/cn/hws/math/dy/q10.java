package cn.hws.math.dy;

public class q10 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * dp[i][j]
     * <p>
     * dp[i][j] = dp[i+1][j-1] && a[i] = a[j]
     */

    public static String q10(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) { //j-i+1<4
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return str.substring(begin,begin + maxLen);
    }






    public static void main(String[] args) {
        System.out.println(q10("aabbaassddeew"));
    }
}
