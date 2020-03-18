package main.java.com.study.leetCode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: whb
 * @date: 2019/10/14 18:38
 * @description: LeetCode-215-求解数组中第K大的元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
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

    /**
     * 查找快速排序的基准点
     *
     * @param a
     * @param l
     * @param h
     * @return
     */
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
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    /**
     * 另一种构建堆的方式
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return 0;
        }
        int len = nums.length;
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(nums, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums[k - 1];
    }

    private static void heapify(int[] arr, int parent, int len) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int smallest = parent;
        if (left < len && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < len && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != parent) {
            swap(arr, parent, smallest);
            heapify(arr, smallest, len);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(normalSortFindKthLarget(nums, k));
        System.out.println(heapSortFindKthLargest(nums, k));
        System.out.println(quickSortFindKthLarget(nums, k));
    }
}
