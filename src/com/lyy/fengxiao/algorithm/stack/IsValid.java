package com.lyy.fengxiao.algorithm.stack;

import java.util.Stack;

public class IsValid {

    /**
     * 有效的括号：20。
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * 输入: "()"
     * 输出: true
     *
     * 解题思路：使用栈的特性来解决。
     */
    public static boolean isValid(String s) {
        if("".equals(s)){
            return true;
        }
        if (s==null || s.length()<2){
            return false;
        }
        if (s.charAt(0)!=')' || s.charAt(0)!=']' || s.charAt(0)!='}'){
            return false;
        }

        Stack<Character> stack=new Stack<>();
        int size=s.length();
        for (int i=0;i<size;i++){
            char c=s.charAt(i);
            if (c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                if (c==')' && stack.peek()!='('){
                    return false;
                }else if (c==']' && stack.peek()!='['){
                    return false;
                }else if (c=='}' && stack.peek()!='{'){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s="()";
        System.out.println(isValid(s));
    }
}
