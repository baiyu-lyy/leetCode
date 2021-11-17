package com.lyy.fengxiao.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 白榆
 * @Date: 2021/8/20 10:55 上午
 */
public class order_13 {

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            final Integer integer = map.getOrDefault(String.valueOf(c), 0);
            num += integer;
            if (i == 0) {
                continue;
            }
            final String s1 = s.substring(i - 1, i + 1);
            if (map.containsKey(s1)) {
                final Integer integer1 = map.getOrDefault(String.valueOf(s.charAt(i - 1)), 0);
                num = num - integer - integer1 + map.get(s1);
            }
        }
        return num;
    }

    public static int romanToInt1(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("M", 1000);
        int num = map.get(String.valueOf(s.charAt(0)));
        int preNum = num;
        for (int i = 1; i < s.length(); i++) {
            Integer integer = map.get(String.valueOf(s.charAt(i)));
            if (preNum < integer) {
                num -= preNum;
                integer -= preNum;
            }
            num += integer;
            preNum = map.get(String.valueOf(s.charAt(i)));
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt1("LVIII"));
    }
}
