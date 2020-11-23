package main.java.com.study.leetCode.sort;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-179-最大数
 * @date： 2020-11-23 8:52
 * 难度：中等
 * 标签：排序
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 *
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 *
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumber {
    /**
     * 自定义排序：字符串降序
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        //数字数组->字符数组转化
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        //自定义排序： 比较 s1 + s2 和 s2 + s1
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
        StringBuffer buffer = new StringBuffer();
        for (String str : strArr) {
            buffer.append(str);
        }
        String res = buffer.toString();
        //特殊情况 若干个零
        return res.charAt(0) == '0' ? "0" : res;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{1}));
        System.out.println(largestNumber(new int[]{10}));
        System.out.println(largestNumber(new int[]{0, 0, 0, 0}));
    }
}
