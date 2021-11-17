package com.lyy.fengxiao.order;

import java.util.Stack;

/**
 * 栈
 *
 * @Author: 白榆
 * @Date: 2021/8/31 11:40 上午
 */
public class order_20 {

    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                final Character pop = stack.pop();
                if (c == ')' && pop == '(') {
                    continue;
                }
                if (c == ']' && pop == '[') {
                    continue;
                }
                if (c == '}' && pop == '{') {
                    continue;
                }
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
}
