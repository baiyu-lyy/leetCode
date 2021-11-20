package com.lyy.fengxiao.order;

/**
 * 两数相除 --倍乘法
 */
public class order_29 {

    public static int divide(int dividend, int divisor) {
        //表示结果正负 1:正  0：负
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        //全转成负数防止 溢出
        long a = dividend > 0 ? -dividend : dividend;
        long b = divisor > 0 ? -divisor : divisor;
        long result = 0;
        while (a <= b) {
            int cnt = 0;
            while ((b << cnt) > a) {
                cnt++;
            }
            if (cnt >= 1) {
                cnt = cnt - 1;
            }
            a = a - (b << cnt);
            result += 1L << cnt;
        }

        return (int) (flag ? result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result : -result);
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 3));
    }
}
