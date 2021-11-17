package com.lyy.fengxiao.order;

/**
 * @Author: 白榆
 * @Date: 2021/7/21 5:28 下午
 */
public class order_9 {

    public static void main(String[] args) {
        int num = 121;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        final String s = String.valueOf(x);
        final int length = s.length();
        int[][] dp = new int[length][length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                max = 2;
            }
        }
        for (int l = 3; l <= length; l++) {
            for (int start = 0; start <= length - l; start++) {
                int end = start + l - 1;
                if (dp[start + 1][end - 1] == 1 && s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 1;
                    max = l;
                }
            }
        }
        return max == length;
    }
}
