package com.lyy.fengxiao.order;

public class order_38 {

    //递归
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String pre = countAndSay(n - 1);
        int count = 0;
        String result = "";
        for (int i = 0; i < pre.length(); i++) {
            if (i == 0) {
                count++;
                continue;
            }
            if (pre.charAt(i) == pre.charAt(i - 1)) {
                count++;
            } else {
                result = result + count + pre.charAt(i - 1);
                count = 1;
            }
            if (i == pre.length() - 1 && count != 0) {
                result = result + count + pre.charAt(i);
            }
        }
        return result;
    }

    //遍历
    public static String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = "1";
        for (int i = 2; i <= n; i++) {
            int start = 0, pos = 0;
            StringBuilder s = new StringBuilder();
            while (pos < pre.length()) {
                while (pos < pre.length() && pre.charAt(start) == pre.charAt(pos)) {
                    pos++;
                }
                s.append(pos - start).append(pre.charAt(start));
                start = pos;
            }
            pre = s.toString();
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
        System.out.println(countAndSay1(5));
    }
}
