package main.java.com.study.leetCode.doublePointer;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/6/4 11:48
 * @description: LeetCode-27-移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveElement {
    /**
     * 采用快慢指针的思想：初始化一个快指针 fast 和一个慢指针 slow，fast 每次移动一步，而 slow 只当 fast 指向的值不等于 val 时才移动一步。
     *
     * @param numbers
     * @param val
     * @return
     */
    public static int removeElement(int[] numbers, int val) {
        int slow = -1, fast = 0;
        while (fast < numbers.length) {
            if (numbers[fast] != val) {
                slow++;
                numbers[slow] = numbers[fast];
            }
            fast++;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 0, slow + 1)));
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
