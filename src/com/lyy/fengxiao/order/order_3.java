package com.lyy.fengxiao.order;

import java.util.HashMap;
import java.util.Map;

/**
 * 双指针
 * @Author: 白榆
 * @Date: 2021/5/29 5:06 下午
 */
public class order_3 {

    public int lengthOfLongestSubstring(String s) {
        final int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, first = -1;
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            if (map.containsKey(c)) {
                first = Math.max(map.get(c), first);
            }
            map.put(c, i);
            max = Math.max(max, i - first);
        }
        return max;
    }
}
