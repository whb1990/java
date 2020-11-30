package main.java.com.study.leetCode.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author： whb
 * @description： LeetCode-1670-设计前中后队列
 * @date： 2020-11-30 15:22
 * 难度：中等
 * 标签：设计、链表
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 *
 * 请你完成 FrontMiddleBack 类：
 *
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 *
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 *
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 *
 *
 * 提示：
 *
 * 1 <= val <= 109
 * 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。
 */
public class FrontMiddleBackQueue {
    /**
     * 使用两个双端队列
     * 始终保持两个deque大小相等，或者右deque比左deque多一个大小
     */
    private Deque<Integer> frontQueue;
    private Deque<Integer> rearQueue;
    private int size;

    public FrontMiddleBackQueue() {
        this.frontQueue = new ArrayDeque<>();
        this.rearQueue = new ArrayDeque<>();
        this.size = 0;
    }

    public void pushFront(int val) {
        if (frontQueue.size() != rearQueue.size()) {
            frontToRear();
        }
        frontQueue.offerFirst(val);
        size++;
    }

    public void pushMiddle(int val) {
        if (frontQueue.size() != rearQueue.size()) {
            frontToRear();
        }
        frontQueue.offerLast(val);
        size++;
    }

    public void pushBack(int val) {
        rearQueue.offerLast(val);
        if (frontQueue.size() != rearQueue.size()) {
            rearToFront();
        }
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        int ret = frontQueue.pollFirst();
        if (frontQueue.size() != rearQueue.size()) {
            rearToFront();
        }
        size--;
        return ret;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        int ret = frontQueue.pollLast();
        if (frontQueue.size() != rearQueue.size()) {
            rearToFront();
        }
        size--;
        return ret;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        if (rearQueue.isEmpty()) {
            size--;
            return frontQueue.pollLast();
        }
        int ret = rearQueue.pollLast();
        if (frontQueue.size() - rearQueue.size() == 2) {
            frontToRear();
        }
        size--;
        return ret;
    }

    private void frontToRear() {
        rearQueue.offerFirst(frontQueue.pollLast());
    }

    private void rearToFront() {
        frontQueue.offerLast(rearQueue.pollFirst());
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
        obj.pushFront(1);
        obj.pushBack(2);
        obj.pushMiddle(3);
        obj.pushMiddle(4);
        System.out.println(obj.popFront());
        System.out.println(obj.popMiddle());
        System.out.println(obj.popMiddle());
        System.out.println(obj.popBack());
        System.out.println(obj.popFront());
    }
}
