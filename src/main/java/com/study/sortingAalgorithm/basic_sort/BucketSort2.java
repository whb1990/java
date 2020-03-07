package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/3/2 15:42
 * @description: 桶排序二
 */
public class BucketSort2 {
    public static void main(String[] args) {
        int[] unsorted = {99, 65, 24, 47, 50, 88, 33, 66, 67, 31, 18};
        System.out.println("**************桶排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        CommonUtils.display(bucketSort(unsorted, 5));
    }

    /**
     * 桶排序算法
     *
     * @param unsorted   待排序数组
     * @param bucketSize 桶的容量
     * @return
     */
    public static int[] bucketSort(int[] unsorted, int bucketSize) {
        //计算待排序的范围
        int min = unsorted[0];
        int max = unsorted[0];
        for (int i = 1; i < unsorted.length; i++) {
            if (unsorted[i] < min) {
                min = unsorted[i];
            }
            if (unsorted[i] > max) {
                max = unsorted[i];
            }
        }
        //计算桶数量
        int bucketCount = (int) Math.floor((max - min) / bucketSize) + 1;
        //定义桶
        int[][] buckets = new int[bucketCount][0];
        //将待排序元素放入桶中
        for (int i = 0; i < unsorted.length; i++) {
            //计算要放入的桶的下标
            int bucketIndex = (int) Math.floor((unsorted[i] - min) / bucketSize);
            buckets[bucketIndex] = arrAppend(buckets[bucketIndex], unsorted[i]);
        }
        int arrIndex = 0;
        //遍历桶并输出元素
        for (int[] bucket : buckets) {
            if (bucket.length == 0) {
                continue;
            }
            //对每个桶单独排序
            InsertSort.insertSort(bucket);
            for (int value : bucket) {
                unsorted[arrIndex++] = value;
            }
        }
        return unsorted;
    }

    /**
     * 扩容数组并填入元素
     *
     * @param arr   数组
     * @param value 元素
     * @return
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
