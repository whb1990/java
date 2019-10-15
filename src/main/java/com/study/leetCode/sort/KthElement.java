package main.java.com.study.leetCode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: whb
 * @date: 2019/10/14 18:38
 * @description: 求解数组中第K个的元素
 * 题目描述：找到倒数第K个元素
 */
public class KthElement {
    /**
     * 普通排序：时间复杂度 O(NlogN)，空间复杂度 O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int normalSortFindKthLarget(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆排序：时间复杂度 O(NlogK)，空间复杂度 O(K)。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int heapSortFindKthLargest(int[] nums, int k) {
        //小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val : nums) {
            priorityQueue.add(val);
            //维护堆大小为
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    /**
     * 快速排序：时间复杂度 O(N)，空间复杂度 O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int quickSortFindKthLarget(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == l) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) {
                ;
            }
            while (a[--j] > a[l] && j > l) {
                ;
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(normalSortFindKthLarget(nums, k));
        System.out.println(heapSortFindKthLargest(nums, k));
        System.out.println(quickSortFindKthLarget(nums, k));
    }
}
