package main.java.com.study.leetCode.stackQueue;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: whb
 * @date: 2020/3/10 11:06
 * @description: LeetCode 496 下一个更大的元素1
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //定义返回结果
        int[] result = new int[nums1.length];
        //数组2的长度
        int len2 = nums2.length;
        //用HashMap存放nums2数组，key为元素，value为比当前元素大的下一元素的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        //临时数组，用于记录nums2中元素的下一个比它大的元素距它的距离
        int[] tmpArr = new int[nums2.length];
        //最后一个元素不存在从当前位置往后比它大的
        tmpArr[len2 - 1] = 0;
        map.put(nums2[len2 - 1], 0);
        //从后向前遍历
        for (int i = len2 - 1; i >= 0; i--) {
            for (int j = i + 1; j < len2; j += tmpArr[j]) {
                if (nums2[i] < nums2[j]) {
                    tmpArr[i] = j - i;
                    map.put(nums2[i], j);
                    break;
                } else if (tmpArr[j] == 0) {
                    tmpArr[i] = 0;
                    map.put(nums2[i], 0);
                    break;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            if (index == 0) {
                result[i] = -1;
            } else {
                result[i] = nums2[index];
            }
        }
        return result;
    }

    /**
     * 最容易想到的笨办法，耗时且耗内存
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nextLargeIndex(nums2, j);
                    break;
                } else {
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    private static int nextLargeIndex(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        int[] nums3 = new int[]{4, 1, 2};
        int[] nums4 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement2(nums3, nums4)));
    }
}
