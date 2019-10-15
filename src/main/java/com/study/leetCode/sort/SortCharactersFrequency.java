package main.java.com.study.leetCode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: whb
 * @date: 2019/10/15 10:15
 * @description: 按照字符出现的字数对字符串排序
 * 示例：
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * 解析：'e'出现了两次，而'r'和't'只出现了一次，所以'e'必须出现在'r'和't'的前面。'r'按字典序又排在't'的前面。
 */
public class SortCharactersFrequency {

    public static String frequencySort(String str) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }
        List<Character>[] frequencyBucket = new ArrayList[str.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(c);
            if (frequencyBucket[frequency] == null) {
                frequencyBucket[frequency] = new ArrayList<>();
            }
            frequencyBucket[frequency].add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "Sort Characters By Frequency";
        System.out.println(frequencySort(str));
    }
}
