package main.java.com.study.leetCode.divideconquer;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-932-漂亮数组
 * @date： 2020-12-02 9:15
 * 难度：中等
 * 标签：分治算法
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 *
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 *
 * 那么数组 A 是漂亮数组。
 *
 *
 *
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 *
 * 示例 1：
 * 输入：4
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：5
 * 输出：[3,1,2,5,4]
 *
 * 提示：
 * 1 <= N <= 1000
 */
public class BeautifulArray {
    /**
     * 分治算法
     * 漂亮数组有以下的性质:
     *
     * （1）A是一个漂亮数组，如果对A中所有元素添加一个常数，那么Ａ还是一个漂亮数组。
     *
     * （2）A是一个漂亮数组，如果对A中所有元素乘以一个常数，那么A还是一个漂亮数组。
     *
     * （3）A是一个漂亮数组，如果删除一些A中一些元素，那么A还是一个漂亮数组。
     *
     * （4) A是一个奇数构成的漂亮数组，B是一个偶数构成的漂亮数组，那么A+B也是一个漂亮数组
     * 比如:{1,5,3,7}+{2,6,4,8}={1,5,3,7,2,6,4,8}也是一个漂亮数组。
     *
     * 所以假设一个{1-m}的数组是漂亮数组，可以通过下面的方式构造漂亮数组{1-2m}:
     *
     * 1、对{1-m}中所有的数乘以2-1，构成一个奇数漂亮数组A。如{1,3,2,4},可以得到{1,5,3,7}
     * 2、对{1-m}中所有的数乘以2,构成一个偶数漂亮数组B,如{1,3,2,4}, 可以得到{2,6,4,8}
     * 4、A+B构成了{1-2m}的漂亮数组。{1,5,3,7}+{2,6,4,8}={1,5,3,7,2,6,4,8}
     * 4、从中删除不要的数字即可。

    *  A 是漂亮数组，则 a * A + b 也是漂亮数组
     * A 为奇数漂亮数组，B 为偶数漂亮数组，A + B 为漂亮数组
     * 数组两两配对，左数组 * 2 - 1 一定是奇数组，右数组 * 2 一定为偶数组，合并一定为漂亮数组
     * 假设 [1] 是最小漂亮数组，按照上面规律递推得到的一定是漂亮数组。
     * |1|1|1|1|1|1|1|1|
     * |1 2|1 2|1 2|1 2|
     * |1 3 2 4|1 3 2 4|
     * |1 5 3 7 2 6 4 8|
     *
     *  * @param N
     *  * @return
     */
    public static int[] beautifulArray(int N) {
        int[] res = new int[N];
        Arrays.fill(res, 1);
        helper(res, 0, N - 1);
        return res;
    }

    private static void helper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        helper(arr, left, middle);
        helper(arr, middle + 1, right);
        for (int i = left; i <= middle; i++) {
            arr[i] = arr[i] * 2 - 1;
        }
        for (int i = middle + 1; i <= right; i++) {
            arr[i] *= 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(beautifulArray(4)));
        System.out.println(Arrays.toString(beautifulArray(5)));
        System.out.println(Arrays.toString(beautifulArray(8)));
    }
}
