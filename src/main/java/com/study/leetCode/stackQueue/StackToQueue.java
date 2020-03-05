package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/3/5 18:42
 * @description: 用栈实现队列
 * 栈的顺序为后进先出，而队列的顺序为先进先出。
 * 使用两个栈实现队列，一个元素需要经过两个栈才能出队列，在经过第一个栈时元素顺序被反转，经过第二个栈时再次被反转，此时就是先进先出顺序。
 */
public class StackToQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.peek());
    }
}
