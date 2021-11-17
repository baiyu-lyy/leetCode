package com.lyy.fengxiao.order;


/**
 * 字符串
 * @Author: 白榆
 * @Date: 2021/8/23 9:57 上午
 */
public class order_14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            final char c = strs[0].charAt(i);
            for (int i1 = 1; i1 < strs.length; i1++) {
                if (strs[i1].length() <= i) {
                    return result.toString();
                }
                if (strs[i1].charAt(i) != c) {
                    return result.toString();
                }
                if (i1 == strs.length - 1) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flower","flower","flower"};
        System.out.println(longestCommonPrefix(strs));
    }
}
