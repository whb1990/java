package main.java.com.study.leetCode.mathematics;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-1356-根据数字二进制下1的数目排序
 * @date： 2020-11-06 11:12
 * 难度：简单
 * 标签：数学、位运算
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * 示例 1：
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * <p>
 * 示例 2：
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * <p>
 * 示例 3：
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * <p>
 * 示例 4：
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * <p>
 * 示例 5：
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * <p>
 * 提示：
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 */
public class SortByBits {
    /**
     * 计算出每个数1的个数，然后排序
     *
     * @param arr
     * @return
     */
    public static int[] sortByBits(int[] arr) {
        Integer[] res = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        Arrays.sort(res, (a, b) -> {
            int c1 = countOne(a);
            int c2 = countOne(b);
            // 相同按原数，不同按位数
            return c1 == c2 ? a - b : c1 - c2;
        });
        for (int i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }
        return arr;
    }

    private static int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= (num - 1);
        }
        return count;
    }

    /**
     * 循环并使用 Integer.bitCount 计算数字中1的个数，乘以10000000（题目中不会大于 10^4）然后加上原数字，
     * 放入数组 arr 中，并对 arr 进行排序，最后 % 10000000 获取原来的数组，填充到原数组返回即可。
     *
     * @param arr
     * @return
     */
    public static int[] sortByBits2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100000000 + arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 100000000;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("-------------方法一-------------------");
        System.out.println(Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
        System.out.println(Arrays.toString(sortByBits(new int[]{10000, 10000})));
        System.out.println(Arrays.toString(sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19})));
        System.out.println(Arrays.toString(sortByBits(new int[]{10, 100, 1000, 10000})));
        System.out.println("**************方法二************************");
        System.out.println(Arrays.toString(sortByBits2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(sortByBits2(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
        System.out.println(Arrays.toString(sortByBits2(new int[]{10000, 10000})));
        System.out.println(Arrays.toString(sortByBits2(new int[]{2, 3, 5, 7, 11, 13, 17, 19})));
        System.out.println(Arrays.toString(sortByBits2(new int[]{10, 100, 1000, 10000})));
    }
}
