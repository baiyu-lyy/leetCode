package com.lyy.fengxiao.algorithm.day;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 白榆
 * @Date: 2021/5/26 10:51 上午
 */
public class ReverseParentheses {

    public String reverseParentheses(String s) {
        String result="";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == ')') {
                StringBuilder str= new StringBuilder();
                while (!stack.isEmpty()){
                    final Character pop = stack.pop();
                    if (pop=='('){
                        stack.push('+');
                        break;
                    }
                    str.append(pop);
                }
                final String string = str.toString();
                if (string.contains("+")){
                    final int index = string.indexOf("+");
                    final String s1 = string.substring(0, index);
                    final String s2 = string.substring(index);
                    result=s1+result+s2;
                }else {
                    result=string+result;
                }
            } else {
                stack.push(c);
            }
        }
        return null;
    }
}
