package main.java.com.study.leetCode.greedyAlgorithm;

/**
 * @author： whb
 * @description： LeetCode-330-按要求补齐数组
 * @date： 2020-12-29 9:02
 * 难度：困难
 * 标签：贪心算法
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 *
 * 示例 1:
 * 输入: nums = [1,3], n = 6
 * 输出: 1
 * 解释:
 * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 * 所以我们最少需要添加一个数字。
 *
 * 示例 2:
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: 我们需要添加 [2, 4]。
 *
 * 示例 3:
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 */
public class MinPatches {
    /**
     * 此题难在厘清思路，实际上要做的是维护一个当前能用和表示的最大数字max，然后根据数组的值来判断需不需要插值。要理解这题的解法，需要先弄明白一个非常关键的道理：
     *
     * 一个数组[a1,a2,a3...an]当前能用和表示的数字区间为[1,max]，此时往数组内补充新数num，则此时能表示的区间为[1,max]∩[num,max + num]
     *
     * 要理解这一点并不复杂，首先由于num被添加进了数组，则能实现的最大的数显然变成了max + num，而由于max之前的数[1, max]都可以通过和实现，那么要实现max + num - k（k <= max），
     *
     * 只需要从max + num的组合里把和为k的组合拿掉即可。那么同理，实现[num,max + num]就相当于用max + num依次减掉[1,max]中的数字，显然可以办到。
     *
     * 本题的贪心思想即来源于此，为了使补充的新数物尽其用，能够直接扩大可表示的区间范围，把补充的num设为max + 1即可。此时能表示的数字区间可以直接更新为[1, max + max + 1]，不会漏掉中间的数字。
     *
     * 所以本题的思路是这样的：
     *
     * 1、当前能表示的最大数字为max，则下一个需要达到的目标数字是max + 1，而当前（未使用）的数组元素为num = nums[idx]
     * 2、判断num与目标值max + 1的大小关系，如果num > max + 1，则说明[max + 1, num - 1]区间内的数字无法表示，必须补充插入新数。
     * 为了使插入的新数既能表示max + 1，又能尽可能覆盖更多的数组（贪心的关键之处），插入的数字就是max + 1，更新max = max + max + 1
     * 3、如果num < max + 1，说明当前的目标值max + 1必然可以实现（因为num >= 1），此时更新max = max + num
     * @param nums
     * @param n
     * @return
     */
    public static int minPathces(int[] nums, int n) {
        long max = 0;
        int index = 0, res = 0, len = nums.length;
        while (max < n) {
            if (index >= len || max + 1 < nums[index]) {
                max += max + 1;
                res++;
            } else {
                max += nums[index];
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minPathces(new int[]{1, 3}, 6));
        System.out.println(minPathces(new int[]{1, 5, 10}, 20));
        System.out.println(minPathces(new int[]{1, 2, 2}, 5));
        System.out.println(minPathces(new int[]{1, 2, 31, 33}, 2147483647));
    }
}
