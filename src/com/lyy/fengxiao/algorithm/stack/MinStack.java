package com.lyy.fengxiao.algorithm.stack;

import java.util.Stack;

public class MinStack {
    /**
     * 最小栈：155。
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     * 示例:
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2. 
     * 提示：
     * pop、top 和 getMin 操作总是在 非空栈 上调用。
     *
     * 解题思路：使用两个java中定义的栈来解决
     * 一个栈用来存放数据，一个栈只存放push的数据比原先最小数据小的数据
     */

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()){
            int min=minStack.peek();
            if (x<=min){
                minStack.push(x);
            }
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        int m=stack.pop();
        int min=minStack.peek();
        //如果最小值和栈移除的数据一样，
        if (m==min){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
