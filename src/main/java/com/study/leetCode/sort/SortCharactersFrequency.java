package main.java.com.study.leetCode.sort;

import java.util.*;

/**
 * @author: whb
 * @date: 2019/10/15 10:15
 * @description: LeetCode-451-按照字符出现的次数对字符串排序
 * 题目描述：给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class SortCharactersFrequency {

    /**
     * 桶排序法
     *
     * @param str
     * @return
     */
    public static String frequencySort(String str) {
        //统计每个元素出现的频次
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //桶排序
        List<Character>[] buckets = new ArrayList[str.length() + 1];
        for (char key : map.keySet()) {
            int index = map.get(key);
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(key);
        }
        //输出结果
        StringBuffer result = new StringBuffer();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    /**
     * 堆排序法
     *
     * @param str
     * @return
     */
    public static String frequencySort2(String str) {
        //统计每个元素出现的频次
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        //构建小顶堆
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> {
            return frequencyMap.get(b) - frequencyMap.get(a);
        });
        for (char key : frequencyMap.keySet()) {
            priorityQueue.add(key);
        }
        //输出结果，元素出现几次就输出几次
        StringBuffer result = new StringBuffer();
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.remove();
            for (int i = 0; i < frequencyMap.get(c); i++) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //String str = "Sort Characters By Frequency";
        String str = "tree";
        System.out.println(frequencySort2(str));
    }
}
