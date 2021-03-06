package main.java.com.study.leetCode.dataStructure.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/6/8 19:27
 * @description: LeetCode-205-同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class Isomorphic {
    /**
     * 解法一：利用哈希表的映射关系，将两个字符串中各字符的对应关系存入表中，之后查找这个表做判断。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    /**
     * 解法二：不用构建各字符一一对应的关系，只要判断对应字符出现的位置相同即可，也就是两个字符串中相同位置的字符，
     * 它们在各自字符串中每次出现的位置都应相同。每次比较两字符首次出现的位置。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic2(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.indexOf(ch1[i]) != t.indexOf(ch2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic2("foo", "bar"));
    }
}
