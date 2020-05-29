package main.java.com.study.leetCode.sort.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/25 23:12
 * @description: 鸡尾酒排序 基于冒泡排序,双向循环
 */
public class CocktailSort {

    public static void cocktailSort(int[] unsorted) {
        boolean swapped = false;
        do {
            for (int i = 0; i < unsorted.length - 1; i++) {
                if (unsorted[i] > unsorted[i + 1]) {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = temp;
                    swapped = true;
                }
            }
            swapped = false;
            for (int j = unsorted.length - 1; j > 0; j--) {
                if (unsorted[j] < unsorted[j - 1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j - 1];
                    unsorted[j - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void cocktailSort2(int[] unsorted) {
        int left = 0, right = unsorted.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (unsorted[i] > unsorted[i + 1]) {
                    unsorted[i] = unsorted[i] ^ unsorted[i + 1];
                    unsorted[i + 1] = unsorted[i] ^ unsorted[i + 1];
                    unsorted[i] = unsorted[i] ^ unsorted[i + 1];
                }
            }
            right--;
            for (int j = right; j > left; j--) {
                if (unsorted[j] < unsorted[j - 1]) {
                    unsorted[j] = unsorted[j] + unsorted[j - 1];
                    unsorted[j - 1] = unsorted[j] - unsorted[j - 1];
                    unsorted[j] = unsorted[j] - unsorted[j - 1];
                }
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int[] unsorted = {6, 2, 4, 1, 5, 9};
        System.out.println("**************鸡尾酒排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        cocktailSort2(unsorted);
        CommonUtils.display(unsorted);
    }
}
