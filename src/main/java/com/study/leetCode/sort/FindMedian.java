package main.java.com.study.leetCode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author: whb
 * @date: 2019/6/24 14:14
 * @description: 取中位数
 */
public class FindMedian {

    //maxHeap保存较小的半边数据，minHeap保存较大的半边数据
    private static PriorityQueue<Integer> maxHeap, minHeap;

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
    public static void addNumber(int num) {
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
    public static double getMedian() {
        if (maxHeap.isEmpty()) {
            return -1;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = (left, right) -> {
            return right.compareTo(left);
        };
        maxHeap = new PriorityQueue<>(100, comparator);
        minHeap = new PriorityQueue<>(100);
        Random random = new Random();
        for (int i = 0; i <= 100; i++) {
            int number = random.nextInt(200);
            addNumber(number);
        }
        System.out.println("minHeap：" + minHeap);
        System.out.println("maxHeap：" + maxHeap);
        System.out.println("中位数：" + getMedian());
    }
}
