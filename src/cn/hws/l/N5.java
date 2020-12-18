package cn.hws.l;

import java.text.SimpleDateFormat;

public class N5 {

    public String longestPalindrome(String s) {

        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
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
        return s.substring(begin, begin + maxLen);
    }


    public String longestPalindromeV2(String s) {
        int length = s.length();
        if (length < 2) return s;

        int index = 0;
        int maxLen = 0;
        /**
         * dp    a  b  c  b  a
         *       i           j
         *
         *    i\j  0 1 2 3 4 5            dp[0][1]     dp[i][j] = dp[i+1][j-1] == true
         *      0  t
         *      1    t
         *      2      t
         *      3        t
         *      4          t
         *      5            t
         *
         */
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if(chars[i] == chars[j]){
                    if(j-i+1 <=3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }

                if(dp[i][j]){
                    if(j-i+1 > maxLen){
                        index = i;
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(index, index + maxLen);
    }


}