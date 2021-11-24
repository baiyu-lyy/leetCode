package com.lyy.fengxiao.order;


import java.util.Stack;

public class order_32 {

    public static int longestValidParentheses(String s) {
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    ans=Math.max(ans,i-stack.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}
