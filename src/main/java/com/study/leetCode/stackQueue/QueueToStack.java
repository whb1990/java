package main.java.com.study.leetCode.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/3/5 18:58
 * @description: 用队列实现栈
 */
public class QueueToStack {

    private Queue<Integer> queue;

    public QueueToStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.top());
    }
}
