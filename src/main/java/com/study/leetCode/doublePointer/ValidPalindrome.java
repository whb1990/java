package main.java.com.study.leetCode.doublePointer;

/**
 * @author: whb
 * @date: 2019/10/14 14:18
 * @description: 回文字符串
 * 题目描述：可以删除一个字符，判断是否能够构成回文字符串
 * 示例：
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return isPalindrome(str, i, j - 1) || isPalindrome(str, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abcba"));
    }
}
