package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/3/5 19:12
 * @description: 最小值栈
 */
public class MinStack {

    private Stack<Integer> dataStack;

    private Stack<Integer> minStack;

    private int min;

    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
