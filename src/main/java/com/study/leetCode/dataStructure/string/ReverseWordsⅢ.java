package main.java.com.study.leetCode.dataStructure.string;

/**
 * @author: whb
 * @date: 2020/6/6 18:01
 * @description: LeetCode-557-反转字符串中的单词Ⅲ
 * 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsⅢ {
    public static String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() == 0) {
                result.append(" ");
            } else {
                for (int j = strArr[i].length() - 1; j >= 0; j--) {
                    result.append(strArr[i].charAt(j));
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
