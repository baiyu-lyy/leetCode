package com.lyy.fengxiao.algorithm.stack;

import java.util.Stack;

public class CalPoints {

    /**
     * 棒球比赛：682。
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
     * 你需要返回你在所有回合中得分的总和。
     * 示例 1:
     * 输入: ["5","2","C","D","+"]
     * 输出: 30
     * 解释:
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到2分。总和是：7。
     * 操作1：第2轮的数据无效。总和是：5。
     * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
     * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
     */
    public static int calPoints(String[] ops) {
        Stack<String> stack=new Stack<>();
        int sum=0;
        for (String s:ops){
            switch (s) {
                case "+":
                    if (!stack.isEmpty()) {
                        String s1 = stack.pop();
                        int temp = 0;
                        //判断栈是否只有一个值
                        if (!stack.isEmpty()) {
                            String s2 = stack.peek();
                            temp = Integer.parseInt(s1) + Integer.parseInt(s2);
                        } else {
                            temp = Integer.parseInt(s1);
                        }
                        //将取出的前两轮得分和这一轮得分放到栈中
                        sum = sum + temp;
                        stack.push(s1);
                        stack.push(String.valueOf(temp));
                    }
                    break;
                case "D":
                    if (!stack.isEmpty()) {
                        int pre = Integer.parseInt(stack.peek());
                        int temp = pre * 2;
                        sum += temp;
                        stack.push(String.valueOf(temp));
                    }
                    break;
                case "C":
                    if (!stack.isEmpty()) {
                        int pre = Integer.parseInt(stack.pop());
                        sum -= pre;
                    }
                    break;
                default:
                    stack.push(s);
                    sum += Integer.parseInt(s);
                    break;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String []strings=new String[]{"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(strings));
    }
}
