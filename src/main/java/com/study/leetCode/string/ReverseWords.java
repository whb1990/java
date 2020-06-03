package main.java.com.study.leetCode.string;

/**
 * @author: whb
 * @date: 2020/6/3 19:19
 * @description: LeetCode-151-翻转字符串中的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {
    public static String reverseWords(String str) {
        if (str.isEmpty() || str.trim().isEmpty()) {
            return "";
        }
        String[] strArr = str.split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!strArr[i].isEmpty()) {
                result.append(strArr[i]).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("the sky is blue 翻转后：" + reverseWords("the sky is blue"));
        System.out.println("  hello world!   翻转后：" + reverseWords("  hello world!  "));
        System.out.println("a good   example 翻转后：" + reverseWords("a good   example"));
    }
}
