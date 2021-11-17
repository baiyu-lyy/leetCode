package com.lyy.fengxiao.order;


/**
 * @Author: 白榆
 * @Date: 2021/7/6 11:23 上午
 */
public class order_8 {

    public static void main(String[] args) {
        String s = "+-2000";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        long result = 0;
        s = s.trim();
        boolean flag = true;
        for (int i = 0; i < s.toCharArray().length; i++) {
            final char c = s.charAt(i);
            if (i==0){
                if (c == '-') {
                    flag = false;
                    continue;
                } else if (c == '+') {
                    continue;
                }
            }
            if (c >= '0' && c <= '9') {
                result = result * 10 + c - 48;
                if (flag) {
                    if (result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (-result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            }else {
                return (int) (flag ? result : -result);
            }
        }
        return (int) (flag ? result : -result);
    }

}
