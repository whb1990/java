package main.java.com.study.leetCode.sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2020/3/3 16:36
 * @description: LeetCode-剑指Offer51.数组中的逆序对
 * 难度：困难
 * 标签：归并排序
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 */
public class ReversePairs {
    /**
     * 这个的关键在于，在合并1~mid和mid+1~r的过程中，只要arr[p1] > arr[p2]，则arr[p2]和arr[p1~mid]都能组成逆序对，
     * 所以我们每次都加上mid-p1+1个数，故可以方便求出逆序数对数。
     */
    public static int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return mergeProcess(nums, 0, nums.length - 1);
    }

    private static int mergeProcess(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int middle = left + ((right - left) >> 1);
        //计算左边区间的逆序对
        int leftPairs = mergeProcess(nums, left, middle);
        //计算右边区间的逆序对
        int rightPairs = mergeProcess(nums, middle + 1, right);
        // 如果整个数组已经有序，则无需合并，注意这里使用小于等于
        if (nums[middle] <= nums[middle + 1]) {
            return leftPairs + rightPairs;
        }
        //计算横跨两个区间的逆序对
        int crossPairs = merge(nums, left, middle, right);
        return leftPairs + rightPairs + crossPairs;
    }

    private static int merge(int[] arr, int left, int middle, int right) {
        int p1 = left, p2 = middle + 1, k = 0, sum = 0;
        int[] help = new int[right - left + 1];
        while (p1 <= middle && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                help[k++] = arr[p1++];
            } else {
                //arr[p1] > arr[p2]，此时p2都小于arr[p1,mid]之间的元素，加上逆序数的个数
                sum += (middle - p1 + 1);
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
        int[] numArr = new int[]{2, 4, 1, 3, 5};
        System.out.println("**************归并排序******************");
        System.out.print("排序前：");
        CommonUtils.display(numArr);
        int res = reversePairs(numArr);
        System.out.print("排序后：");
        CommonUtils.display(numArr);
        System.out.println("逆序对数量：" + res);
        numArr = new int[]{7, 5, 6, 4};
        System.out.print("排序前：");
        CommonUtils.display(numArr);
        res = reversePairs(numArr);
        System.out.print("排序后：");
        CommonUtils.display(numArr);
        System.out.println("逆序对数量：" + res);
    }
}
