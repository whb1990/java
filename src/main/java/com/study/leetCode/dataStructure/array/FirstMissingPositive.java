package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author： whb
 * @description： LeetCode-41-缺失的第一个正数
 * @date： 2020-11-28 9:36
 * 难度：困难
 * 标签：数组
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class FirstMissingPositive {
    /**
     * 原地置换法
     * 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
     * 然后再遍历一次数组查当前下标是否和值对应，
     * 如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * 负号标记（原地哈希）
     *对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。这是因为如果 [1,N] 都出现了，那么答案是 N+1，否则答案是 [1,N] 中没有出现的最小正整数。
     * 这样一来，将所有在 [1,N] 范围内的数放入哈希表，也可以得到最终的答案。而给定的数组恰好长度为 N，这让我们有了一种将数组设计成哈希表的思路：
     * 对数组进行遍历，对于遍历到的数 x，如果它在 [1,N] 的范围内，那么就将数组中的第 x−1 个位置（注意：数组下标从 0 开始）打上「标记」。
     * 在遍历结束之后，如果所有的位置都被打上了标记，那么答案是 N+1，否则答案是最小的没有打上标记的位置加 1。
     * 那么如何设计这个「标记」呢？继续利用上面的提到的性质：由于我们只在意 [1,N] 中的数，因此可以先对数组进行遍历，把不在 [1,N] 范围内的数修改成任意一个大于 N 的数（例如 N+1）。
     * 这样一来，数组中的所有数就都是正数了，因此就可以将「标记」表示为「负号」。
     *
     * 算法的流程如下：
     * 1、将数组中所有小于等于 0 的数修改为 N+1；
     * 2、遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为 ∣x∣，其中 ∣∣ 为绝对值符号。如果 ∣x∣∈[1,N]，那么给数组中的第 ∣x∣−1 个位置的数添加一个负号。
     *    注意如果它已经有负号，不需要重复添加；
     * 3、在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则答案是第一个正数的位置加 1。
     * @param nums
     * @return
     */
    public static int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //将数组中所有小于等于 0 的数修改为 N+1；
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        //遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为 |x|，其中 ∣∣ 为绝对值符号。
        // 如果∣x∣∈[1,N]，那么给数组中的第 |x| - 1个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加。
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则答案是第一个正数的位置加 1。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println("===========负号标记法=============");
        System.out.println(firstMissingPositive2(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive2(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive2(new int[]{7, 8, 9, 11, 12}));
    }
}
