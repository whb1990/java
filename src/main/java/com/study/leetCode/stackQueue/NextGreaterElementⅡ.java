package main.java.com.study.leetCode.stackQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-503-下一个更大的元素Ⅱ
 * @date： 2020-10-28 14:57
 * 难度：中等
 * 标签：栈
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 */
public class NextGreaterElementⅡ {
    /**
     * 单调栈
     * 比如输入一个数组[2,1,2,4,3]，你返回数组[4,2,4,-1,4]。拥有了环形属性，最后一个元素 3 绕了一圈后找到了比自己大的元素 4。
     * <p>
     * 一般是通过 % 运算符求模（余数），来获得环形特效
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        //如果不存在比它的数返回-1
        Arrays.fill(res, -1);
        // 存储的是索引index
        Stack<Integer> stack = new Stack<>();
        // 由于是循环数组,对于末位元素,要往后循环考虑到其前一位数也就是倒数第二个数
        for (int i = 0; i < 2 * len - 1; i++) {
            // 对于当前元素,弹出栈中小于当前元素的元素,这些被弹出的元素的"下一个更大元素"就是当前元素
            // 一个元素只有入栈后再被弹出,才能得到该元素的"下一个更大元素",否则无"下一个更大元素",res[i]默认为-1
            // 例如,对于最大的元素,其一直留在栈中无法被弹出,因此其"下一个更大元素"默认为-1
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 1, 2, 4, 3})));
    }
}
