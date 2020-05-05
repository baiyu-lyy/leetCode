package com.lyy.fengxiao.algorithm.stack;

import java.util.Stack;

public class BackspaceCompare {

    /**
     * 比较含退格的字符串：844。
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * 示例 1：
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * 示例 3：
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     */
    public boolean backspaceCompare(String S, String T) {
        if ("".equals(S) && "".equals(T)) {
            return true;
        }
        if ("".equals(S)) {
            return false;
        }
        if ("".equals(T)) {
            return false;
        }
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stack1.push(String.valueOf(S.charAt(i)));
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                stack2.push(String.valueOf(T.charAt(i)));
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }

        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        if (stack1.isEmpty()) {
            return false;
        }
        if (stack2.isEmpty()) {
            return false;
        }

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()){
            if (!stack1.pop().equals(stack2.pop())){
                return false;
            }
        }

        return true;
    }
}
