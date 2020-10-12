package main.java.com.study.leetCode.dataStructure.array;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-189-旋转数组
 * @date： 2020-10-12 10:39
 * 难度：中等
 * 标签：数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {
    /**
     * 反转法
     * 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * <p>
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n−k 个元素，就能得到想要的结果。
     * <p>
     * 假设 n=7且 k=3 。
     * <p>
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        System.out.println("旋转前的数组：" + Arrays.toString(nums));
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println("旋转后的数组：" + Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 环状替换法
     * 对于一个长度为 n 的数组，整体移动 k 个位置
     * <p>
     * 当 n 和 k 的最大公约数 等于 1 的时候：1 次遍历就可以完成交换；比如 n = 5, k = 3
     * 当 n 和 k 的最大公约数 不等于 1 的时候：1 次遍历是无法完成的所有元素归位，需要 m (最大公约数) 次
     * 所以在最大公约数不为 1 的时候
     * 比如 [A,B,C,D,E,F]此时 n=6 ,k=4 ，其最大公约数为 2 ,因此需要 2 轮循环
     * 我们就可以把这个数组分成两部分来看：
     * 第 1 轮循环（分组1）： A E C [A]
     * 第 2 轮循环（分组2）： B F D [B]
     * <p>
     * 即：每一轮循环只会在自己的那一组上不停的遍历。所以
     * 数组的前 m 个元素，其实就是每一个分组的第一个元素，我们控制流程在每次发现一轮循环走到原点时+1
     * <p>
     * 那么如何判断所有的分组都执行归位了呢？ 可以有两种方法来控制
     * <p>
     * 第一种：我们就用最大公约数 m 来控制外循环，代表总共有 m 轮循环
     * 第二种：由于n个元素归位需要n次交换，所以我们定义一个count代表交换次数，当 count = n 时完成
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        System.out.println("旋转前的数组：" + Arrays.toString(nums));
        int len = nums.length;
        //移动总次数，总次数只需要
        int count = 0;
        k %= len;
        //nums.leng为偶数时，会形成多个环 1 2 3 4（1 3 1,2 4 2,3,1,3） ，为奇数时则只有一个环 1 2 3 4 5 （1 3 5 2 4 1），start=0不会增加
        for (int start = 0; count < len; start++) {
            //当前坐标
            int cur = start;
            //前一个坐标
            int pre = nums[cur];
            do {
                //下一个坐标
                int next = (cur + k) % len, tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
                count++;
            } while (start != cur);
        }
        System.out.println("旋转后的数组：" + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
