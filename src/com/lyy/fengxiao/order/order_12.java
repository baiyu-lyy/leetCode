package com.lyy.fengxiao.order;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 贪心算法
 * @Author: 白榆
 * @Date: 2021/5/24 10:02 下午
 */
public class order_12 {

    public static String intToRoman(int num) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        StringBuilder result = new StringBuilder();
        List<Map.Entry<Integer, String>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        Collections.reverse(entries);
        for (Map.Entry<Integer, String> entry : entries) {
            final Integer key = entry.getKey();
            while (key <= num) {
                num = num - key;
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }

    public static String intToRoman1(int num){
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] keys={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {

            while (nums[i]<=num){
                result.append(keys[i]);
                num=num-nums[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman1(3));
    }
}
