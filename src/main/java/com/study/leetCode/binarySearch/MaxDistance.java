package main.java.com.study.leetCode.binarySearch;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-1552-两球之间的距离
 * @date： 2020-11-25 18:51
 * 难度：中等
 * 标签：二分查找
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 *
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 *
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 *
 * 示例 1：
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 *
 * 示例 2：
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 *
 *
 * 提示：
 *
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 */
public class MaxDistance {
    /**
     * 1、两球的最小距离的最小值，是1；最小距离的最大值是 (最后位置的球坐标 - 最前位置的球坐标) / (球数-1)，这里需要先对position数组排序，那么易得最小球间距离的最大值为 (position[position.length - 1] - position[0]) 。
     * 2、有最小和最大，直觉想到二分法。 以二分的中间值，作为间距去摆放球。如果摆放的球数 >=m, 可认为需要增加球间距 （同时保存中间值作为候选答案）； 否则需要减少球间距。
     *
     * @param position
     * @param m
     * @return
     */
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1, high = position[position.length - 1] - position[0];
        while (low < high) {
            int middle = low + ((high - low) >> 1);
            int need = 1;
            int min = position[0];
            for (int i = 1; i < position.length; i++) {
                if (position[i] - min > middle) {
                    need++;
                    min = position[i];
                }
            }
            if (need >= m) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }
}
