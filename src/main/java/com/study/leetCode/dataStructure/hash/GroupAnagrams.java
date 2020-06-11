package main.java.com.study.leetCode.dataStructure.hash;

import java.util.*;

/**
 * @author: whb
 * @date: 2020/6/11 10:47
 * @description: LeetCode-49-字母异位词
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {
    /**
     * 遍历字符串数组，对每个字符串用Arrays.sort进行排序，将排序得到的每个结果作为map的key，而value则是一个List
     * 如果value为空则创建，不为空则把没有排序前的字符串放进去。 最后将Map里的多个value依此存到一个List里即可。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //字符串转成字符数组
            char[] charArr = str.toCharArray();
            //字符数组排序，这样字母异位词就变成相同的字符数组
            Arrays.sort(charArr);
            //字符数组转字符串，这样字母异位词就变成相同的字符串
            String tmp = new String(charArr);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            //相同字母的异位词放到同一个集合
            map.get(tmp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
