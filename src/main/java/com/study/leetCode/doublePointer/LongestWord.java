package main.java.com.study.leetCode.doublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/10/14 18:17
 * @description: 最长子序列
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 * "apple"
 * 题目描述：删除s中一些字符，使得它构成字符串列表d中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序中最小的字符串。
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

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        d.add("bpplad");
        System.out.println(findLongestWord(s, d));
    }

}
