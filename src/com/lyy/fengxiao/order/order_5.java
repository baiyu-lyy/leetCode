package com.lyy.fengxiao.order;


/**
 * @Author: 白榆
 * @Date: 2021/6/6 4:49 下午
 */
public class order_5 {

    public static String longestPalindrome(String s) {
        final int length = s.length();
        if (length < 2) {
            return s;
        }
        int[][] dp = new int[length][length];
        int start = 0, maxLen = 1;
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l)==s.charAt(r)){
                    if (r-l<3){
                        dp[l][r]=1;
                    }else {
                        dp[l][r]=dp[l+1][r-1];
                    }
                    if (dp[l][r]==1){
                        final int i = r - l + 1;
                        if (maxLen<i){
                            maxLen=i;
                            start=l;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        final String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
