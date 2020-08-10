package main.java.com.study.leetCode.dataStructure.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/8/10 9:58
 * @description: LeetCode-696-计数二进制子串
 * 难度：简单
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * 示例 2 :
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */
public class CountBinarySubString {
    /**
     * 双指针法
     * pre用于统计前面出现的最大次数，cur用来统计当前出现的次数，若cur<=pre则表明可以使得res++
     *
     * @param s
     * @return
     */
    public static int countBinarySubString(String s) {
        int pre = 0, cur = 1, result = 0, len = s.length();
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                result++;
            }
        }
        return result;
    }

    /**
     * 按字符分组
     * 将字符串 s 按照 0 和 1 的连续段分组，存在 counts数组中，例如 s = 00111011，可以得到这样的 counts数组：counts={2,3,1,2}。
     * 这里counts 数组中两个相邻的数一定代表的是两种不同的字符。假设 counts 数组中两个相邻的数字为 u 或者 v，它们对应着 u 个 0 和 v 个 1，或者 u 个 1 和 v 个 0。
     * 它们能组成的满足条件的子串数目为 min{u,v}，即一对相邻的数字对答案的贡献。
     * <p>
     * 只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案。
     *
     * @param s
     * @return
     */
    public static int countBinarySubString2(String s) {
        int ptr = 0, len = s.length();
        List<Integer> counts = new ArrayList<>();
        while (ptr < len) {
            int count = 0;
            char c = s.charAt(ptr);
            while (ptr < len && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int result = 0;
        for (int i = 1; i < counts.size(); i++) {
            result += Math.min(counts.get(i), counts.get(i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubString("00110011"));
        System.out.println(countBinarySubString("10101"));
        System.out.println(countBinarySubString("00111011"));
        System.out.println(countBinarySubString2("00110011"));
        System.out.println(countBinarySubString2("10101"));
        System.out.println(countBinarySubString2("00111011"));
    }
}
