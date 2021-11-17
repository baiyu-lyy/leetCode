package com.lyy.fengxiao.order;

import java.util.*;

/**
 * 哈希表、字符串、回溯  以空间换时间
 * @Author: 白榆
 * @Date: 2021/8/24 10:03 上午
 */
public class order_17 {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> keys = new HashMap<>();
        keys.put(2, Arrays.asList("a", "b", "c"));
        keys.put(3, Arrays.asList("d", "e", "f"));
        keys.put(4, Arrays.asList("g", "h", "i"));
        keys.put(5, Arrays.asList("j", "k", "l"));
        keys.put(6, Arrays.asList("m", "n", "o"));
        keys.put(7, Arrays.asList("p", "q", "r", "s"));
        keys.put(8, Arrays.asList("t", "u", "v"));
        keys.put(9, Arrays.asList("w", "x", "y", "z"));

        Map<Integer, List<String>> result = new HashMap<>();
        for (int i = 0; i < digits.length(); i++) {
            result.put(i, new ArrayList<>());
            final int num = digits.charAt(i) - 48;
            final List<String> words = keys.get(num);
            final List<String> curr = result.get(i);
            for (String word : words) {
                if (i == 0) {
                    curr.add(word);
                    continue;
                }
                final List<String> pre = result.get(i - 1);
                for (String s : pre) {
                    curr.add(s + word);
                }
            }
            result.put(i, curr);
        }
        return result.get(digits.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
}
