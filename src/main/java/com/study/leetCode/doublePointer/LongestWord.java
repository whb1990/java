package main.java.com.study.leetCode.doublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/10/14 18:17
 * @description: LeetCode-524-最长子序列
 * 题目描述：给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 * 说明:
 * <p>
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 * 解题思路：通过删除字符串s中的一些字符得到字符串t，可以认为t是s的子序列，可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 */
public class LongestWord {

    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubStr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private static boolean isSubStr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static String findLongestWord2(String s, List<String> d) {
        String result = "";
        for (String str : d) {
            if (result.length() > str.length() || (result.length() == str.length() && result.compareTo(str) < 0)) {
                continue;
            }
            int i = 0, j = 0;
            while (i < str.length() && j < s.length()) {
                if (s.charAt(j) == str.charAt(i)) {
                    i++;
                }
                j++;
                if (i == str.length()) {
                    result = str;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        d.add("bpplad");
        System.out.println(findLongestWord2(s, d));
    }

}
