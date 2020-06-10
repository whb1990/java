package main.java.com.study.leetCode.binarySearch;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/6/10 15:38
 * @description: LeetCode-658-找到k个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 * <p>
 * 说明:
 * <p>
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 */
public class FindClosestElements {

    /**
     * 暴力解法
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int start = 0, end = arr.length - 1;
        while (end - start >= k) {
            if (x - arr[start] > arr[end] - x) {
                start++;
            } else {
                end--;
            }
        }
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        System.out.println(Arrays.toString(Ints.toArray(result)));
        result = findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        System.out.println(Arrays.toString(Ints.toArray(result)));
    }
}
