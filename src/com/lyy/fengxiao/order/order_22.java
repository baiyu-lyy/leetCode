package com.lyy.fengxiao.order;

import java.util.*;

/**
 * @Author: 白榆
 * @Date: 2021/9/3 10:13 上午
 */
public class order_22 {

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        int[][] dp = new int[2 * n][2 * n];
        int length = 2 * n;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 0;
            if (i != length - 1) {
                dp[i][i + 1] = 1;
            }
        }

        for (int l = 2; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int end = i + l;
                dp[i][end] = dp[i + 1][end - 1];
            }
        }
        backTrack(dp, 0, n, 0, new String[2 * n], result);
        return new ArrayList<>(result);
    }

    private static void backTrack(int[][] dp, int le, int n, int num, String[] track, Set<String> set) {
        if (num == n) {
            StringBuilder ss = new StringBuilder();
            for (String s : track) {
                ss.append(s);
            }
            set.add(ss.toString());
            return;
        }
        for (int i = le; i < 2 * n; i++) {
            for (int j = i + 1; j < 2 * n; j++) {
                if (le == 0) {
                    track = new String[2 * n];
                    num = 0;
                }
                if (dp[i][j] == 1 && track[i] == null && track[j] == null) {
                    track[i] = "(";
                    track[j] = ")";
                    num++;
                    backTrack(dp, i + 1, n, num, track, set);
                    track[i] = null;
                    track[j] = null;
                    num--;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}
