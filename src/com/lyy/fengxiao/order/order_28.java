package com.lyy.fengxiao.order;

/**
 * @Author: 白榆
 * @Date: 2021/9/8 11:17 上午
 */
public class order_28 {

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        final int hl = haystack.length();
        final int nl = needle.length();
        boolean flag = false;
        for (int i = 0; i <= hl - nl; i++) {
            int hEnd = i + nl - 1;
            int start = 0, end = nl - 1;
            while (start <= end) {
                char h1 = haystack.charAt(i + start);
                char h2 = haystack.charAt(hEnd);
                char n1 = needle.charAt(start);
                char n2 = needle.charAt(end);
                if (h1 == n1 && h2 == n2) {
                    start++;
                    end--;
                    hEnd--;
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack, needle));
    }
}
