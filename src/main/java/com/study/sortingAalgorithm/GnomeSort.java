package main.java.com.study.sortingAalgorithm;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/25 23:48
 * @description: 地精排序：号称最简单的排序算法,只有一层循环,默认情况下前进冒泡,一旦遇到冒泡的情况发生就往回冒,直到把这个数字放好为止。
 */
public class GnomeSort {

    public static void gnomeSort(int[] unsorted) {
        int i = 0;
        while (i < unsorted.length) {
            if (i == 0 || unsorted[i - 1] <= unsorted[i]) {
                i++;
            } else {
                int temp = unsorted[i];
                unsorted[i] = unsorted[i - 1];
                unsorted[i - 1] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] unsorted = {6, 2, 4, 1, 5, 9};
        System.out.println("**************地精排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        gnomeSort(unsorted);
        CommonUtils.display(unsorted);
    }
}
