package main.java.com.study.leetCode.dataStructure.hash;

import java.util.*;

/**
 * @author: whb
 * @date: 2020/6/11 15:15
 * @description: LeetCode-249-移位字符串分组
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 * <p>
 * "abc" -> "bcd" -> ... -> "xyz"
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 * <p>
 * 示例：
 * <p>
 * 输入: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
 * 输出:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */
public class GroupStrings {

    /**
     * 解题思路：首先看一下相同移位距离string的特性：
     * 相同的移位string，拥有相同的移位距离，比如abc、bcd、xyz都是移位了1个距离，根据这个特性，我们可以把bcd、xyz恢复到abc。
     * 利用HashMap，把最原始归位string作为key，把可以恢复到原始的归为string的所有strings（List）当做value存入map。
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupStrings(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //利用 char - 'a' 把所有相同移位距离的strings 转换成 同一个原始string 存入map
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> groups = groupStrings(strs);
        for (List<String> list : groups) {
            System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
        }
    }
}
