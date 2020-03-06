package main.java.com.study.leetCode.sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2020/3/6 17:13
 * @description: 使用归并排序计算数组的小和
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和。
 * <p>
 * 例子;
 * <p>
 * [1,3,4 2,5]
 * <p>
 * 1左边比1小的数，没有；
 * <p>
 * 3左边比3小的数，1；
 * <p>
 * 4左边比4小的数，1、3；
 * <p>
 * 2左边比2小的数，1；
 * <p>
 * 5左边比5小的数，1、3、4、2； 所以小和为1+1+3+1+1+3+4+2=16
 */
public class MergeSortSum {
    public static int mergeSortSum(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int left = 0, right = arr.length - 1;
        return mergeProcess(arr, left, right);
    }

    private static int mergeProcess(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int middle = left + ((right - left) >> 1);
        return mergeProcess(arr, left, middle)
                + mergeProcess(arr, middle + 1, right)
                + merge(arr, left, middle, right);
    }

    private static int merge(int[] arr, int left, int middle, int right) {
        int sum = 0;
        int[] help = new int[right - left + 1];
        int p1 = left, p2 = middle + 1;
        int k = 0;
        while (p1 <= middle && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                sum += arr[p1] * (right - p2 + 1);
                help[k++] = arr[p1++];
            } else {
                help[k++] = arr[p2++];
            }
        }
        while (p1 <= middle) {
            help[k++] = arr[p1++];
        }
        while (p2 <= right) {
            help[k++] = arr[p2++];
        }
        for (int i = 0; i < k; i++) {
            arr[i + left] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numArr = new int[]{1, 3, 4, 2, 5};
        System.out.println("**************归并排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        System.out.println(mergeSortSum(numArr));
        CommonUtils.display(numArr);
    }
}


