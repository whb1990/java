package main.java.com.study.leetCode.doublePointer;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/5/29 19:00
 * @description: LeetCode - 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        //reverseString(s);
        reverseStringDoublePointer(s);
    }

    /**
     * 解法一：遍历n/2遍，相对于中心点进行交换
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2; i++) {
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }

    /**
     * 解法二：双指针
     *
     * @param s
     */
    public static void reverseStringDoublePointer(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char leftKey = s[left];
            char rightKey = s[right];
            s[left++] = rightKey;
            s[right--] = leftKey;
        }
        System.out.println(Arrays.toString(s));
    }
}
