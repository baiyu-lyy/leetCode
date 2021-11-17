package com.lyy.fengxiao.order;

/**
 * @Author: 白榆
 * @Date: 2021/7/5 6:00 下午
 */
public class order_7 {

    public static void main(String[] args) {
        int s = -2147483648;
        System.out.println(reverse(s));
    }

    public static int reverse(int x) {
        String s = String.valueOf(x);
        boolean flag = true;
        if (x < 0) {
            flag=false;
            s=s.substring(1);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        long aLong = Long.parseLong(builder.toString());
        if (!flag){
            aLong=-aLong;
        }
        if (aLong<-Math.pow(2,31) || aLong>Math.pow(2,31)-1){
            return 0;
        }
        return (int) aLong;
    }
}
