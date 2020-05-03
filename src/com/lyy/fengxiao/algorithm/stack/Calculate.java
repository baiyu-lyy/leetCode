package com.lyy.fengxiao.algorithm.stack;

import java.util.Stack;

public class Calculate {

    /**
     * 基本计算器：224。
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     * 示例 1:
     * 输入: "1 + 1"
     * 输出: 2
     * 示例 2:
     * 输入: " 2-1 + 2 "
     * 输出: 3
     * 示例 3:
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     * 说明：
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     */
    public static int calculate(String s) {
        s=s.trim();
        if (!s.contains("+")&&!s.contains("-")){
            if (s.contains("(")){
                return Integer.parseInt(s.substring(1,s.length()-1).trim());
            }
            return Integer.parseInt(s);
        }

        Stack<String> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        int size=s.length();
        for (int i = 0; i < size; i++) {
            char c=s.charAt(i);
            if (c>='0' && c<='9'){
                if (i!=0){
                    if (s.charAt(i-1)>='0' && s.charAt(i-1)<='9'){
                        int num=Integer.parseInt(s1.pop());
                        num=num*10+Integer.parseInt(String.valueOf(c));
                        s1.push(String.valueOf(num));
                        continue;
                    }
                }
                s1.push(String.valueOf(c));
            }
            if (c=='('){
                s1.push(String.valueOf(c));
                continue;
            }
            if (c=='+' || c=='-'){
                if (!s2.isEmpty()) {
                    String c1=s1.pop();
                    String c2=s1.pop();
                    if (c1.equals("(") || c2.equals("(")){
                        s1.push(c2);
                        s1.push(c1);
                        s2.push(c);
                        continue;
                    }
                    int num1 = Integer.parseInt(String.valueOf(c1));
                    int num2 = Integer.parseInt(String.valueOf(c2));
                    int sum = 0;
                    char pre = s2.pop();
                    if (pre == '+') {
                        sum = num1 + num2;
                    } else {
                        sum = num2 - num1;
                    }
                    s1.push(String.valueOf(sum));
                }
                s2.push(c);
                continue;
            }
            if (c==')'){
                while (!s1.peek().equals("(")){
                    int sum=0;
                    String c1=s1.pop();
                    String c2=s1.pop();
                    if (c1.equals("(") || c2.equals("(")){
                        s1.push(c1);
                        break;
                    }
                    int num1 = Integer.parseInt(c1);
                    int num2 = Integer.parseInt(c2);
                    char op=s2.pop();
                    if (op=='+'){
                        sum=num1+num2;
                    }else {
                        sum=num2-num1;
                    }
                    if (s1.peek().equals("(")) {
                        s1.pop();
                    }
                    s1.push(String.valueOf(sum));
                    break;
                }
            }
        }
        if (!s1.isEmpty()){
            if (s1.size()==1){
                return Integer.parseInt(s1.pop());
            }
            int num1 = Integer.parseInt(String.valueOf(s1.pop()));
            int num2 = Integer.parseInt(String.valueOf(s1.pop()));
            char op=s2.pop();
            if (op=='+'){
                return num1+num2;
            }else {
                return num2-num1;
            }
        }

        return Integer.parseInt(s1.pop());
    }

    public static void main(String[] args) {
        System.out.println(calculate("(4+9)"));
    }
}
