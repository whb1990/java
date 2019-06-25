package main.java.com.study.sortingAalgorithm;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/26 0:06
 * @description: 奇偶排序：基本思路是奇数列排一趟序,偶数列排一趟序,再奇数排,再偶数排,直到全部有序
 */
public class OddEventSort {

    public static void oddEventSort(int[] unsorted) {
        int temp;
        for (int i = unsorted.length - 1; i > unsorted.length / 2 - 1; i--) {
            //奇数排序
            for (int j = 1; j <= i; j += 2) {
                if (j == unsorted.length - 1) {
                    break;
                }
                if (unsorted[j] > unsorted[j + 1]) {
                    temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
            //偶数排序
            for (int j = 0; j <= i; j += 2) {
                if (j == unsorted.length - 1) {
                    break;
                }
                if (unsorted[j] > unsorted[j + 1]) {
                    temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{12, 33, 45, 33, 13, 55, 34, 7, 6};
        System.out.println("**************奇偶排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        oddEventSort(unsorted);
        CommonUtils.display(unsorted);
    }
}
