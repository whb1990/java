package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/26 1:27
 * @description: 梳排序
 */
public class CombSort {
    /**
     * 梳排序
     *
     * @param unsorted 待排序列
     */
    public static void combSort(int[] unsorted) {
        int gap = unsorted.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            int i = 0;
            swapped = false;
            while (i + gap < unsorted.length) {
                if (unsorted[i] > unsorted[i + gap]) {
                    swap(unsorted, i, i + gap);
                    swapped = true;
                }
                i++;
            }
        }
    }

    /**
     * 按从小到大的顺序交换数组
     *
     * @param a 传入的数组
     * @param b 传入的要交换的数b
     * @param c 传入的要交换的数c
     */
    public static void swap(int[] a, int b, int c) {
        if (b == c) {
            return;
        }
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }


    public static void main(String[] args) {
        int[] unsorted = {11, 95, 45, 15, 78, 84, 51, 24, 12};
        System.out.println("**************梳排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        combSort(unsorted);
        CommonUtils.display(unsorted);
    }
}
