package main.java.com.study.leetCode.doublePointer;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2019/10/14 14:29
 * @description: 归并两个有序数组
 * 题目描述：把归并结果存到第一个数组上
 * 解题思路：需要从尾开始遍历，否则在第一个数组上归并得到的值会覆盖还未进行归并比较的值
 */
public class MergeSortedArray {
    /**
     * 不构造新数组的方式合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 构造一个新数组的方式进行合并
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] mergeArr(int[] nums1, int[] nums2) {
        //变量用于存储两个集合应该被比较的索引（存入新集合就加一）
        int index1 = 0, index2 = 0;
        int[] resultArr = new int[nums1.length + nums2.length];
        for (int i = 0; i < resultArr.length; i++) {
            //两数组都未遍历完，相互比较后加入
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] <= nums2[index2]) {
                    resultArr[i] = nums1[index1];
                    index1++;
                } else {
                    resultArr[i] = nums2[index2];
                    index2++;
                }
            } else if (index1 < nums1.length) {
                //nums2已经遍历完，无需比较，直接将剩余nums1加入
                resultArr[i] = nums1[index1];
                index1++;
            } else if (index2 < nums2.length) {
                //nums1已经遍历完，无需比较，直接将剩余nums2加入
                resultArr[i] = nums2[index2];
                index2++;
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 4, 5};
        System.out.println(Arrays.toString(mergeArr(nums1, nums2)));
        //后面的3个0相当于占位符
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        merge(nums1, 3, nums2, 3);
    }
}
