package main.java.com.study.leetCode.doublePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: whb
 * @date: 2019/10/14 14:07
 * @description: 反转字符串中的元音字符
 * 解题思路：使用双指针指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
 * 示例：Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsString {

    /**
     * 定义元音字符集合
     */
    private static final HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String str) {
        int i = 0, j = str.length() - 1;
        char[] result = new char[str.length()];
        while (i <= j) {
            char ci = str.charAt(i);
            char cj = str.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

}
