package main.java.com.study.sortingAalgorithm;

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

    public static void main(String[] args) {
        int[] unsorted = {6, 2, 4, 1, 5, 9};
        System.out.println("**************鸡尾酒排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        cocktailSort(unsorted);
        CommonUtils.display(unsorted);
    }
}
