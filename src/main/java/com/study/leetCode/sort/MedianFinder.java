package main.java.com.study.leetCode.sort;

import java.util.PriorityQueue;

/**
 * @author: whb
 * @date: 2019/6/24 14:14
 * @description: LeetCode-295-数据流的中位数
 * 难度：困难
 * 标签：堆、设计
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder {

    /**
     * maxHeap保存较小的半边数据，minHeap保存较大的半边数据
     */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }

    /**
     * offer  新增头元素
     * peek   查询头元素
     * poll   队列中删除头元素
     * 1）比较两个堆的大小，第一次肯定相同，此时两个堆都没有数据，把第一个数据放入大堆
     * 2）比较两个堆的大小，第二次肯定不同，如果num值小于大堆头部的值，小堆加入大堆头部元素，大堆加入当前值
     * 注意：并不是线程安全的，多线程访问会有并发问题。
     *
     * @param num
     */
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && num > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    /**
     * 获取中位数
     * 如果maxHeap和minHeap大小不同，则maxHeap肯定至少有一个元素。
     */
    public double findMedian() {
        if (maxHeap.isEmpty()) {
            return -1;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
