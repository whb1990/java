package main.java.com.study.leetCode.sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2020/3/3 16:36
 * @description: 归并排序求解逆序数
 * 描述：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 给你一个数组，求出这个数组中逆序对的总数。
 * 概括：如果a[i] > a[j]且 i < j，则a[i]和a[j]构成一个逆序对。
 * 示例：在[2,4,1,3,5]中，有3个逆序对（2,1），（4,1），（4,3），则返回3。
 */
public class ReversePairs {

    public static void main(String[] args) {
        int[] numArr = new int[]{2, 4, 1, 3, 5};
        System.out.println("**************归并排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        System.out.println(reversePairs(numArr));
        CommonUtils.display(numArr);
    }

    /**
     * 这个的关键在于，在合并1~mid和mid+1~r的过程中，只要arr[p1] > arr[p2]，则arr[p2]和arr[p1~mid]都能组成逆序对，
     * 所以我们每次都加上mid-p1+1个数，故可以方便求出逆序数对数。
     */
    public static long reversePairs(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return mergeProcess(arr, 0, arr.length - 1);
    }

    private static long mergeProcess(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return mergeProcess(arr, L, mid)
                + mergeProcess(arr, mid + 1, R)
                //merge要放在后面
                + merge(arr, L, mid, R);
    }

    private static long merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0;
        long sum = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                help[k++] = arr[p1++];
            } else {
                //arr[p1] > arr[p2]，此时p2都小于arr[p1,mid]之间的元素
                //加上逆序数的个数
                sum += (mid - p1 + 1);
                help[k++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[k++] = arr[p1++];
        }
        while (p2 <= R) {
            help[k++] = arr[p2++];
        }
        for (int i = 0; i < k; i++) {
            arr[i + L] = help[i];
        }
        return sum;
    }
}
