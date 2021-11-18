package com.lyy.fengxiao.order;

public class order_29 {

    public static int divide(int dividend, int divisor) {
        //表示结果正负 1:正  0：负
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        //全转成负数防止 溢出
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        long result = 0;
        while (dividend <= divisor) {
            int cnt = 0;
            while ((divisor << cnt) > dividend) {
                cnt++;
            }
            if (cnt >= 1) {
                cnt = cnt - 1;
            }
            dividend = dividend - (divisor << cnt);
            result += 1L << cnt;
        }

        return (int) (flag ? result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result : -result);
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 3));
    }
}
